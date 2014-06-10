package poolingpeople.mock.entities;

import java.util.Date;
import javax.inject.Inject;

import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.TaskSerializerQualifier;

public class Task extends AbstractEntity<Task> {

    private String title = "default title";
    private Long date = new Date().getTime();

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
