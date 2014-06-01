package poolingpeople.mock.relations;

import java.util.Set;

import poolingpeople.mock.entities.AbstractEntity;

public abstract class AbstractRelation {

	protected static class ValidPair<S,E>{

	}

	protected Set<ValidPair<?,?>> validPairs;

	protected AbstractEntity<?> startEntity;
	protected AbstractEntity<?> endEntity;

	public AbstractRelation setStartEntity(AbstractEntity<?> startEntity) {
		this.startEntity = startEntity;
		return this;
	}

	public AbstractRelation setEndEntity(AbstractEntity<?> endEntity) {
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
