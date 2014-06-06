/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poolingpeople.mock.cdi;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import poolingpeople.mock.entities.Task;
import poolingpeople.mock.entities.User;

/**
 *
 * @author alacambra
 */
public class EntityModelProvider {
    
    @Inject
    Instance<Task> taskInstances;
    
    @Inject
    Instance<User> userInstances;
    
    public <T> T getInstance(Class<T> clazz){
        if ( clazz.isAssignableFrom(Task.class) ){
            return (T) taskInstances.get();
        }
        
        if ( clazz.isAssignableFrom(User.class) ){
            return (T) userInstances.get();
        }
        
        throw new ContextedRuntimeException("Instance provider not found")
                .addContextValue("given class", clazz.getCanonicalName());
    }
    
}
