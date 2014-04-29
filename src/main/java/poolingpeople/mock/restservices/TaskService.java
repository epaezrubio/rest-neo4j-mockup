package poolingpeople.mock.restservices;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import poolingpeople.mock.entities.Task;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@Path("tasks")
@Stateless
public class TaskService extends AbstractService<Task>
{
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public TaskService(){
		super(Task.class);
	}

}

