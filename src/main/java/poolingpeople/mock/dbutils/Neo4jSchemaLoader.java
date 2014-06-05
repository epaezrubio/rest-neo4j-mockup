package poolingpeople.mock.dbutils;

import javax.inject.Inject;



public class Neo4jSchemaLoader {

	@Inject
	Neo4jRestApiAdapter restAPI;
	
	public void loadConstraints(){
		
	}
	
	public void createLabels(){
		
	}
	
	public void createIndexes(){
//		restAPI.execute(requestType, uri, params)
	}
	
}
