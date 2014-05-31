package poolingpeople.mock.relations;

public class IsSubtaskOfRelation extends Neo4jRelation{

	@Override
	public String name() {
		return RelationName.isSubtaskOf.name();
	}

	@Override
	protected void validateRelation() {
		// TODO Auto-generated method stub
		
	}

}
