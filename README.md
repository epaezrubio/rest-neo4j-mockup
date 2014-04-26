Application example
====
### Stack:
* Wildfly http://www.wildfly.org/
* Neo4j embedded (http://api.neo4j.org/2.0.1/)
* java EE 7: JAX-RS (RestEasy in case of wildfly)
* Angular or what desired

### Neo4j
######Instantiating an embedded database:
```org.neo4j.graphdb.GraphDatabaseService dbService = new GraphDatabaseFactory().newEmbeddedDatabase( db_path );```
######Class wrapper
```
class SomeClass{
  org.neo4j.graphdb.Node underlyingNode;
  
  public Object getAttribute(){
    return underlyingNode.getProperty(attributeKey);
  }
  
  public Object setAttribute(Object value){
    return underlyingNode.setProperty(attributeKey, value);
  }
}
```
######Transactions (http://api.neo4j.org/2.0.1/org/neo4j/graphdb/Transaction.html)
```
try ( Transaction tx = graphDb.beginTx() )
 {
     // operations on the graph
     // ...
     tx.success();
 }
 ```
