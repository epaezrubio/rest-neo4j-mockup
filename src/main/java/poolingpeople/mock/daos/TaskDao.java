package poolingpeople.mock.daos;

import java.util.ArrayList;
import java.util.List;

import poolingpeople.mock.entities.Task;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskDao extends AbstractDao<Task> {
    
    public TaskDao(){
            super("Task");
        }

	public List<Task> getTasksByAssignee(){

        List<Task> tasks = new ArrayList<>();
        tasks.add(instance.get());
        tasks.add(instance.get());
        tasks.add(instance.get());
        tasks.add(instance.get());
        tasks.add(instance.get());

        return tasks;
	}
}
