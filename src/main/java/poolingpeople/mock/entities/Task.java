package poolingpeople.mock.entities;

import javax.inject.Inject;

import poolingpeople.mock.entities.serializers.ISerializer;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Task extends AbstractEntity<Task>{
	private String title;
	private Long date;

	@Inject
	public Task(ISerializer<Task> serialize){
		super(serialize);
	}
	
	public String getTitle() {
		return title;	
	}
	
	public Long getDate() {
		return date;	
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDate(Long date) {
		this.date = date;
	}
}































