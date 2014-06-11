package poolingpeople.mock.restservices;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import poolingpeople.mock.cdi.EntityModelProvider;
import poolingpeople.mock.daos.RelationDao;
import poolingpeople.mock.daos.TaskDao;
import poolingpeople.mock.daos.UserDao;
import poolingpeople.mock.entities.Task;
import poolingpeople.mock.entities.serializers.JSONSerializable;
import poolingpeople.mock.entities.serializers.SerializationView;
import poolingpeople.mock.relations.IsAssignedToRelation;
import poolingpeople.mock.vo.CollectionVO;
import poolingpeople.mock.vo.CountedElementsVO;
import poolingpeople.mock.vo.VOProvider;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc --> @generated
 */
@Path("tasks")
@RequestScoped
public class TaskService {

    @Inject
    TaskDao taskDao;

    @Inject
    RelationDao relationDao;

    @Inject
    EntityModelProvider modelProvider;

    @Inject
    VOProvider voProvider;

    @Inject
    UserDao userDao;

    @Context
    UriInfo uriInfo;


    @Inject
    public TaskService() {

    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response create(String body) {

        Task entity = modelProvider.getInstance(Task.class).getSerializer().load(body);
        taskDao.create(entity);
        return Response.created(
                uriInfo.getAbsolutePathBuilder().path(String.valueOf(entity.getUuid())).build())
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response read(@PathParam("id") String id) {

        JSONSerializable serializable = this.taskDao.loadById(id);
        return Response.ok().entity(serializable.getSerializer()
                .serialize(SerializationView.PRIVATE)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response update(@PathParam("id") String id, String body) {
        taskDao.update(modelProvider.getInstance(Task.class).getSerializer().load(body), id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public javax.ws.rs.core.Response delete(@PathParam("id") String id) {
        taskDao.delete(id);
        return Response.noContent().build();
    }

    @GET
    public javax.ws.rs.core.Response list() {

        CollectionVO c = voProvider.getInstance(CollectionVO.class).setCollection(taskDao.list());
        return Response.ok(c.getSerializer().serializeArray(SerializationView.PUBLIC).toString()).build();

    }

    @GET
    @Path("assignedto/{assigneeId}")
    public Response getTasksOfAssignee(@PathParam("assigneeId") String assigneeId){

        List<Task> tasks = taskDao.getTasksByAssignee();
        CountedElementsVO countedElementsVO =
                voProvider.getInstance(CountedElementsVO.class)
                        .setCollectionVO(voProvider.getInstance(CollectionVO.class)
                                .setCollection(tasks));

        return Response.ok().entity(countedElementsVO.getSerializer().serialize().toString()).build();
    }

    @PUT
    @Path("assignto/{assigneeId}")
    public Response assignTaskTo(@PathParam("assigneeId") String assigneeId){
        IsAssignedToRelation isAssignedToRelation = new IsAssignedToRelation().setStartEntity(null).setEndEntity(null);
        relationDao.createRelation(isAssignedToRelation);
        return Response.accepted().build();
    }


}
