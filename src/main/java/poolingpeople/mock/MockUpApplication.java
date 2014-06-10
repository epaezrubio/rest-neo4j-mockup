package poolingpeople.mock;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author alacambra
 */
@javax.ws.rs.ApplicationPath("rest")
public class MockUpApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        resources.add(WebApplicationExceptionMapper.class);
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(poolingpeople.mock.WebApplicationExceptionMapper.class);
        resources.add(poolingpeople.mock.restservices.AbstractService.class);
        resources.add(poolingpeople.mock.restservices.TaskService.class);
        resources.add(poolingpeople.mock.restservices.UserService.class);
    }
}
