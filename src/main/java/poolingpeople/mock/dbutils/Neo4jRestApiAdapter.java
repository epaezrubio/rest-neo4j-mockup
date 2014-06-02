package poolingpeople.mock.dbutils;

import java.util.HashMap;

import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.batch.CypherResult;
import org.neo4j.rest.graphdb.entity.RestNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Neo4jRestApiAdapter extends RestAPIFacade{

	RestAPI restAPI;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Neo4jRestApiAdapter() {
		super("http://localhost:7474/db/data");
		restAPI = this;
	}

	public void createConstraint(String label, String attribute){
		String query =  
				new StringBuilder("CREATE CONSTRAINT ON (entity:").append(label)
				.append(") ASSERT entity.").append(attribute)
				.append(" IS UNIQUE").toString();
		
		CypherResult r = restAPI.query(query, FluidMap.get().put("attr1", "1").put("attr2", "2"));
		logger.error(r.asMap().toString());
		
	}
	
	public void createNodeWithLabel(){
		
	}
	
	public static void main(String[] args){
		Neo4jRestApiAdapter adapter = new Neo4jRestApiAdapter();
		adapter.beginTx();
		RestNode node = adapter.createNode(FluidMap.get().put("attr1", "1").put("attr2", "2"));
		adapter.addLabels(node, "l1", "l2");
		adapter.createConstraint("l1", "attr1");
	}
	
	@SuppressWarnings("serial")
	private static class FluidMap extends HashMap<String, Object>{
		
		static FluidMap get(){
			return new FluidMap();
		}
		
		public FluidMap put(String key, Object value){
			super.put(key, value);
			return this;
		}
	}
	
}
