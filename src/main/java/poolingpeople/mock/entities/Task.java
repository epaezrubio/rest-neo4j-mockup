package poolingpeople.mock.entities;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Task extends AbstractEntity<Task> 
{
	String title;
	Long date;

	public Task(){
		super();
	}
	
	public String getTitle() {
		return title;	
	}
	
	public Long getDate() {
		// TODO : to implement
		return date;	
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDate(Long date) {
		this.date = date;
	}
}

