package poolingpeople.mock.restservices;

import javax.ws.rs.Path;
import poolingpeople.mock.daos.UserDao;
import poolingpeople.mock.entities.User;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc --> @generated
 */
@Path("/users")
public class UserService extends AbstractService<User> {

    
    public UserService() {
        super(User.class, new UserDao());
    }

}
