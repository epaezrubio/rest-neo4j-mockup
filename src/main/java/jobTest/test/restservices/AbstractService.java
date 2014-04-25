package jobTest.test.restservices;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.neo4j.graphdb.Transaction;

import jobTest.test.entities.AbstractEntity;


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

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	protected org.neo4j.graphdb.GraphDatabaseService dbService;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public AbstractService(){
		super();
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
		// TODO : to implement
		instance.get().deserialize(body).updateOrCreate().getId();

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
		instance.get().deserialize(body).updateOrCreate();
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
		Transaction tx = dbService.beginTx();
		try {
			dbService.getNodeById(id).delete();
			tx.success();
		} catch (Exception e) {
			tx.failure();
			throw e;
		} finally {
			tx.close();
		}
		
		return Response.noContent().build();	
	}

}

