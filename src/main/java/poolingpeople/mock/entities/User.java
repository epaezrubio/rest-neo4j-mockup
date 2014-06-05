package poolingpeople.mock.entities;

import javax.inject.Inject;

import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.UserSerializerQualifier;

public class User extends AbstractEntity<User> {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    @Inject
    public User(@UserSerializerQualifier ISerializer<User> serialize) {
        super(serialize);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
