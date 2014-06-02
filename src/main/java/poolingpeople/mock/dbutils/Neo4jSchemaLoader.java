package poolingpeople.mock.dbutils;

import javax.inject.Inject;

import org.neo4j.rest.graphdb.RestAPI;


public class Neo4jSchemaLoader {

	@Inject
	RestAPI restAPI;
	
	public void loadConstraints(){
		
	}
	
	public void createLabels(){
		
	}
	
	public void createIndexes(){
//		restAPI.execute(requestType, uri, params)
	}
	
}
