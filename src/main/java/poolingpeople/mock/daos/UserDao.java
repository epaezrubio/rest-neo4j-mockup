package poolingpeople.mock.daos;

import java.util.List;

import poolingpeople.mock.entities.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super("user");
    }

    public List<User> getFriends() {
        return null;
    }

}
