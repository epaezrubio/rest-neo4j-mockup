Application example
====
### Stack:
* Wildfly http://www.wildfly.org/
* Neo4j embedded (http://api.neo4j.org/2.0.1/) or 
* Neo4j RestApi (https://github.com/alacambra/java-rest-binding/tree/2.0-labels-and-indexes)
* java EE 7: JAX-RS (RestEasy in case of wildfly)
* Angular or what desired

### Neo4j
######Instantiating an embedded database:
```org.neo4j.graphdb.GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( db_path );```
######Instantiating a RestDatabase:
see https://github.com/alacambra/java-rest-binding/tree/2.0-labels-and-indexes#usage
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
### JAX-RS (https://jersey.java.net/documentation/latest/jaxrs-resources.html)
```
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public javax.ws.rs.core.Response postMethod(String body);

@GET
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public javax.ws.rs.core.Response getMethod(@PathParam("id") Long id);
	
@PUT
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
public javax.ws.rs.core.Response puthMethod(@PathParam("id") Long id, String body);
	
@DELETE
@Path("{id}")
public javax.ws.rs.core.Response deleteMEthod(@PathParam("id") Long id);
```
