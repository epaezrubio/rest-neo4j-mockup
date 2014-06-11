package poolingpeople.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import javax.ws.rs.core.Application;
//import org.jboss.resteasy.core.registry.ClassNode;
/**
 *
 * @author alacambra
 */
@javax.ws.rs.ApplicationPath("rest")
public class MockUpApplication extends Application
{

    Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
//        try {
//            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
//            resources.add(jacksonProvider);
//        } catch (ClassNotFoundException ex) {
//            logger.warn("org.codehaus.jackson.jaxrs.JacksonJsonProvider not found", ex);
//        }

        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
//        resources.add(poolingpeople.mock.WebApplicationExceptionMapper.class);
        resources.add(poolingpeople.mock.restservices.TaskService.class);
        resources.add(poolingpeople.mock.restservices.UserService.class);
    }
}
