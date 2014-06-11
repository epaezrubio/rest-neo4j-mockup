package poolingpeople.mock.restservices;

import poolingpeople.mock.daos.RelationDao;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("usertask")
public class UserTaskService {

    @Inject
    RelationDao relationDao;

    @Path("{userId}/{taskId}")
    @PUT
    public Response assignTaskToUser(@PathParam("userId") String userId, @PathParam("taskId") String taskId){
        return null;
    }

}
