package poolingpeople.mock.relations;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import poolingpeople.mock.entities.AbstractEntity;

public abstract class AbstractRelation {

    protected RelationValidator validator;
    protected Set<Map.Entry<Class<?>, Class<?>>> validPairs = new HashSet<>();
    protected AbstractEntity<?> startEntity;
    protected AbstractEntity<?> endEntity;

    private static class NopRelationValidatior implements RelationValidator {

        @Override
        public String getMessage() {
            return "that is the default validator";
        }

        @Override
        public Boolean validate(AbstractRelation relation){
            return true;
        }

    }

    protected AbstractRelation() {
        validator = new NopRelationValidatior();
    }

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

    protected void validateRelation() {
        validator.validate(this);
    }

}
