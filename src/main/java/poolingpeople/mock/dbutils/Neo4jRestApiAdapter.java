package poolingpeople.mock.dbutils;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.client.Client;

import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.batch.CypherResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import poolingpeople.mock.daos.TaskDao;
import poolingpeople.mock.entities.Task;

public class Neo4jRestApiAdapter {

    RestAPI restAPI;
    
    @Inject
    Client client;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Neo4jRestApiAdapter() {
        restAPI = new RestAPIFacade("http://localhost:7474/db/data");
    }

    public void createConstraint(String label, String attribute) {
        String query
                = new StringBuilder("CREATE CONSTRAINT ON (entity:").append(label)
                .append(") ASSERT entity.").append(attribute)
                .append(" IS UNIQUE").toString();

        
        CypherResult r = restAPI.query(query, FluidMap.get().put("attr1", "1").put("attr2", "2"));
        logger.error(r.asMap().toString());

    }

    public void createNodeWithLabel() {

    }
    
    public CypherResult query(String query, Map<String, Object> params){
        return null;
    }

    public static void main(String[] args) {
//		Neo4jRestApiAdapter adapter = new Neo4jRestApiAdapter();
//		adapter.beginTx();
//		RestNode node = adapter.createNode(FluidMap.get().put("attr1", "1").put("attr2", "2"));
//		adapter.addLabels(node, "l1", "l2");
//		adapter.createConstraint("l1", "attr1");
        TaskDao dao = new TaskDao();
        Task t = new Task();
        t.setId(2313L);
        t.setDate(1L);
        dao.create(t);
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
