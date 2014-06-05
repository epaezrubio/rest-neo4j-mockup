package poolingpeople.mock.entities;

import javax.inject.Inject;

import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.TaskSerializerQualifier;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc --> @generated
 */
public class Task extends AbstractEntity<Task> {

    private String title = "default title";
    private Long date = 1L;

    @Inject
    public Task(@TaskSerializerQualifier ISerializer<Task> serialize) {
        super(serialize);
    }

    public Task() {
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

    public User getAssignee() {
        return null;
    }
}
