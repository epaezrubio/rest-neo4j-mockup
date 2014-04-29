package poolingpeople.mock.restservices;

import java.util.ArrayList;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.neo4j.rest.graphdb.entity.RestNode;

import poolingpeople.mock.entities.AbstractEntity;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class AbstractService<T extends AbstractEntity<T>>
{

	@Inject
	Instance<T> instance;

	@Context
	UriInfo uriInfo;

	Class<T> currentClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@Inject
	protected org.neo4j.graphdb.GraphDatabaseService dbService;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	protected AbstractService(Class<T> clazz){
		super();
		currentClass = clazz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response create(String body) {

		T entity = instance.get().deserialize(body).updateOrCreate();

		return Response.created(
				uriInfo.getAbsolutePathBuilder().path(String.valueOf(entity.getId())).build())
				.build();	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response read(@PathParam("id") Long id) {

		return Response.ok().entity(
				instance.get().load(id).serialize())
				.build();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response update(@PathParam("id") Long id, String body) {
		instance.get().load(id).deserialize(body).updateOrCreate();
		return Response.noContent().build();	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@DELETE
	@Path("{id}")
	public javax.ws.rs.core.Response delete(@PathParam("id") Long id) {
		dbService.getNodeById(id).delete();
		return Response.noContent().build();	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@GET
	public javax.ws.rs.core.Response list() {

		Iterable<RestNode> it = ((RestGraphDatabase) dbService).getRestAPI().getNodesByLabel(currentClass.getSimpleName());
		JsonArrayBuilder builder = Json.createArrayBuilder();

		for(Node n : it){
			builder.add(instance.get().load(n).serialize());
		}

		return Response.ok(builder.build().toString()).build();
	}

}














































