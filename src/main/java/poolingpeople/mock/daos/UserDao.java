package poolingpeople.mock.daos;

import java.util.List;

import poolingpeople.mock.entities.User;

public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super("user");
    }

    public List<User> getFriends() {
        return null;
    }

}
