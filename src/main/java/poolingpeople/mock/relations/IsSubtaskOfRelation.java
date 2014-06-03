package poolingpeople.mock.relations;

import org.apache.commons.lang3.tuple.ImmutablePair;
import poolingpeople.mock.entities.Task;

public class IsSubtaskOfRelation extends Neo4jRelation {

    public IsSubtaskOfRelation() {
        validPairs.add(new ImmutablePair(Task.class, Task.class));
    }
    
    @Override
    public String name() {
        return RelationName.isSubtaskOf.name();
    }
}
