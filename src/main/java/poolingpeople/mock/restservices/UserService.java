package poolingpeople.mock.restservices;

import javax.inject.Inject;
import javax.ws.rs.Path;
import poolingpeople.mock.daos.AbstractDao;
import poolingpeople.mock.daos.UserDao;
import poolingpeople.mock.entities.User;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc --> @generated
 */
@Path("/users")
public class UserService {

    @Inject
    private UserDao dao;
            
    
    public UserService() {
    }

    public AbstractDao<User> getDefaultDao() {
        return dao;
    }

}
