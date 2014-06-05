package poolingpeople.mock.daos;

import java.util.List;

import poolingpeople.mock.entities.Task;

public class TaskDao extends AbstractDao<Task> {
    
        public TaskDao(){
            super("Task");
        }

	public List<Task> getTaskByAssignee(){
		return null;
	}
}
