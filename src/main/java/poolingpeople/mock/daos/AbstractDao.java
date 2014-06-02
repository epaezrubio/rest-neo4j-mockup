package poolingpeople.mock.daos;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.neo4j.graphdb.Node;
import org.neo4j.rest.graphdb.batch.CypherResult;
import poolingpeople.mock.dbutils.Neo4jRestApiAdapter;
import poolingpeople.mock.relations.Neo4jRelation;

public abstract class AbstractDao<T> {

	@Transient
	protected Neo4jRestApiAdapter restAPI = new Neo4jRestApiAdapter();
        private String currentClass;
	
        protected AbstractDao(){
            currentClass = "task1";
//                    ((ParameterizedType)this.getClass()
//                        .getGenericSuperclass())
//                        .getActualTypeArguments()[0].toString();
        }
        
	public T loadById(@NotNull String uuid){
		CypherResult result = restAPI.query("", null);
		return null;
	}
	
	protected T loadByNode(@NotNull Node node){
		return null;
	}
	
	public void update(@NotNull T model, @NotNull String uuid){
		
	}
	
	public void create(@NotNull T model){
//		CREATE (n:Person { name : 'Andres', title : 'Developer' })
		String query = "CREATE (n:" + currentClass + "{props}) return n";
		ObjectMapper mapper = new ObjectMapper();
		try {
                    Map map = mapper.readValue(mapper.writeValueAsString(model), Map.class);
                    Map<String, Object> props = new HashMap<>();
                    props.put("props", map);
                            
                    CypherResult result = restAPI.query(query, props);
                    result.getData().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
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











