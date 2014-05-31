package poolingpeople.mock.relations;

import java.util.Set;

import org.neo4j.graphdb.RelationshipType;

import poolingpeople.mock.entities.AbstractEntity;

public abstract class Neo4jRelation implements RelationshipType{
	
	protected static class ValidPair<S,E>{
		
	}
	
	protected Set<ValidPair<?,?>> vps;
	
	protected AbstractEntity<?> startEntity;
	protected AbstractEntity<?> endEntity;
	
	public Neo4jRelation setStartEntity(AbstractEntity<?> startEntity) {
		this.startEntity = startEntity;
		return this;
	}
	
	public Neo4jRelation setEndEntity(AbstractEntity<?> endEntity) {
		this.endEntity = endEntity;
		return this;
	}
	
	public AbstractEntity<?> getStartEntity() {
		return startEntity;
	}
	
	public AbstractEntity<?> getEndEntity() {
		return endEntity;
	}
	
	protected abstract void validateRelation();
	

}

