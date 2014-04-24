package jobTest.test.restservices;

import java.net.URI;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@Inject
	public org.neo4j.graphdb.GraphDatabaseService dbService;

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


		return Response.created(
				URI.create(
						String.valueOf("http://localhost/rest/" + instance.get().deserialize(body).updateOrCreate().getId())))
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
	public javax.ws.rs.core.Response delete(long id) {
		dbService.getNodeById(id).delete();
		return Response.ok().build();	
	}

}

