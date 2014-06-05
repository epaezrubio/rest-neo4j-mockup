package poolingpeople.mock.restservices;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import poolingpeople.mock.daos.AbstractDao;
import poolingpeople.mock.daos.TaskDao;
import poolingpeople.mock.entities.Task;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc --> @generated
 */
@Path("tasks")
@RequestScoped
public class TaskService extends AbstractService<Task> {

    @Inject
    TaskDao dao;

    @Inject
    public TaskService() {
        super(Task.class);
    }

    @Override
    public AbstractDao<Task> getDefaultDao() {
        return dao;
    }

}
