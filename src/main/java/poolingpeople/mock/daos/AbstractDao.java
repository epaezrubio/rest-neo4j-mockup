package poolingpeople.mock.daos;

import javax.validation.constraints.NotNull;

import org.neo4j.graphdb.Node;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.batch.CypherResult;

import poolingpeople.mock.relations.Neo4jRelation;

public abstract class AbstractDao<T> {

	protected RestAPI restAPI;
	
	public T loadById(@NotNull String uuid){
		CypherResult result = restAPI.query("", null);
		return null;
	}
	
	protected T loadByNode(@NotNull Node node){
		return null;
	}
	
	public void update(@NotNull T model, @NotNull String uuid){
		
	}
	
	public void create(@NotNull T model, @NotNull String uuid){
		
	}
	
	protected void updateOrCreate(@NotNull T model, String uuid){
		
	}
	
	public void delete(@NotNull String uuid){
		
	}
	
	protected void delete(@NotNull Long id){
		
	}
	
	public void deleteAll(){
		
	}
	
	public void relate(Neo4jRelation relation){
		
	}
	
}











