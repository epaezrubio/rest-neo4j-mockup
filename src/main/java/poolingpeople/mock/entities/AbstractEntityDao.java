package poolingpeople.mock.entities;

import javax.validation.constraints.NotNull;

import org.neo4j.graphdb.Node;
import org.neo4j.rest.graphdb.RestAPI;

import poolingpeople.mock.relations.Neo4jRelation;

public abstract class AbstractEntityDao<T> {

	protected RestAPI restAPI;
	
	public T loadById(@NotNull String uuid){
		restAPI.query("", null);
		return null;
	}
	
	protected T loadbyNode(@NotNull Node node){
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
	
	protected void delete(@NotNull Long uuid){
		
	}
	
	public void relate(Neo4jRelation relation){
		
	}
	
}











