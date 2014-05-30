package poolingpeople.mock.entities;

import java.io.StringReader;
import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;


public abstract class AbstractEntity<T>
{
	
	@Inject
	protected org.neo4j.graphdb.GraphDatabaseService dbService;
	protected org.neo4j.graphdb.Node underlyingNode;
	Long id;

	public AbstractEntity(){
		super();
	}

	public Long getId() {
		return id;	
	}

	public String serialize(){
		if (id == null) {
			underlyingNode = dbService.createNode();	
		}

		Field[] fields = this.getClass().getDeclaredFields();

		JsonObjectBuilder builder = Json.createObjectBuilder();

		for ( int i = 0; i < fields.length; i++ ){

			Field field = fields[i];

			try {

				String key = field.getName();
				Object value = field.get(this);

				if ( field.get(this) != null ){
					if (value.getClass().isAssignableFrom(Integer.class)){
						builder.add(key, (Integer)value);
					}else if (value.getClass().isAssignableFrom(Long.class)){
						builder.add(key, (Long)value);
					} else {
						builder.add(key, value.toString());
					}
				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}


		return builder.build().toString();
	}

	public T deserialize(String json){
		JsonParser parser = Json.createParser(new StringReader(json));
		while (parser.hasNext()){
			if(parser.next().equals(JsonParser.Event.KEY_NAME)){
				String name = parser.getString();
				Event event = parser.next();
				switch(event){
				case VALUE_STRING:
					try {
						this.getClass().getDeclaredField(name).setAccessible(true);
						this.getClass().getDeclaredField(name).set(this, parser.getString());
					} catch (IllegalArgumentException | IllegalAccessException
							| NoSuchFieldException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case VALUE_NUMBER:
					try {
						this.getClass().getDeclaredField(name).setAccessible(true);
						this.getClass().getDeclaredField(name).set(this, parser.getLong());
					} catch (IllegalArgumentException | IllegalAccessException
							| NoSuchFieldException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				default:
					break;

				}
			}
		}

		return (T) this;
	}

	public T updateOrCreate() {
			if (id == null) {
				Label label = DynamicLabel.label(this.getClass().getSimpleName());
				underlyingNode = dbService.createNode(label);	
				id = underlyingNode.getId();
			}

			Field[] fields = this.getClass().getDeclaredFields();

			for ( int i = 0; i < fields.length; i++ ){
				Field field = fields[i];
				field.setAccessible(true);
				if ( "id".equals(field.getName()) || "underlyingNode".equals(field.getName()) || "dbService".equals(field.getName())) continue;
				try {

					String key = field.getName();
					Object value = field.get(this);

					if( "DELETE".equals(value)){
						underlyingNode.removeProperty(key);
					}

					if ( value != null ){
						underlyingNode.setProperty(key, value);
					}

				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		return (T) this;
	}

	public T load(Long id){

		this.id = id;

		try ( Transaction tx = dbService.beginTx() )
		{
			underlyingNode = dbService.getNodeById(id);
			for(String key : underlyingNode.getPropertyKeys()){
				try {
					this.getClass().getDeclaredField(key).setAccessible(true);
					this.getClass().getDeclaredField(key).set(this, underlyingNode.getProperty(key));
				} catch (IllegalArgumentException | IllegalAccessException
						| NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
			}
			tx.success();
		}

		return (T) this;
	}

	public T load(Node n){

		underlyingNode = n;
		for(String key : underlyingNode.getPropertyKeys()){
			try {
				this.getClass().getDeclaredField(key).setAccessible(true);
				this.getClass().getDeclaredField(key).set(this, underlyingNode.getProperty(key));
			} catch (IllegalArgumentException | IllegalAccessException
					| NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}

		return (T) this;
	}

	public void setId(Long id) {
		this.id = id;
	}
}





















