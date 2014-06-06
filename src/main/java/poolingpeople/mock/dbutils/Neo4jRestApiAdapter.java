package poolingpeople.mock.dbutils;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import poolingpeople.mock.cdi.EntityModelProvider;
import poolingpeople.mock.entities.HasUUID;

@ApplicationScoped
public class Neo4jRestApiAdapter {
    
    @Inject
            EntityModelProvider modelProvider;
    
//    @Inject
    Client client;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public Neo4jRestApiAdapter() {
        
    }
    
    public void createConstraint(String label, String attribute) {
    }
    
    public void createNodeWithLabel(Object Model, String... label) {
        
    }
    
    public void updateNode(Object Model, String uuid) {
        
    }
    
    public <R extends HasUUID> R getEntity(String uuid, Class<R> clazz){
        return (R)modelProvider.getInstance(clazz).setUuid(uuid); 
    }
    
    /*
    * That should be uuid, uuid, string, relParams? Look at the query
    */
    public void createRelation(
            Object startNode,
            Object endNode,
            Object relation){
        
        
    }
    
    public Object query(String query, Map<String, Object> params){
        return null;
    }
    
    @SuppressWarnings("serial")
    private static class FluidMap extends HashMap<String, Object> {
        
        static FluidMap get() {
            return new FluidMap();
        }
        
        public FluidMap put(String key, Object value) {
            super.put(key, value);
            return this;
        }
    }
}
