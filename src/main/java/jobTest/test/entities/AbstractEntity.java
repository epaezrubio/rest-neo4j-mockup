package jobTest.test.entities;

import java.io.StringReader;
import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.neo4j.graphdb.Transaction;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class AbstractEntity<T>
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	@Inject
	public org.neo4j.graphdb.GraphDatabaseService dbService;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public org.neo4j.graphdb.Node underlyingNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public Long id;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public AbstractEntity(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public Long getId() {
		return id;	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public String serialize(){
		if (id == null) {
			underlyingNode = dbService.createNode();	
		}

		Field[] fields = this.getClass().getFields();

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

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public T deserialize(String json){
		JsonParser parser = Json.createParser(new StringReader(json));
		while (parser.hasNext()){
			if(parser.next().equals(JsonParser.Event.KEY_NAME)){
				String name = parser.getString();
				Event event = parser.next();
				switch(event){
					case VALUE_STRING:
						try {
							this.getClass().getField(name).set(this, parser.getString());
						} catch (IllegalArgumentException | IllegalAccessException
								| NoSuchFieldException | SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
	
					case VALUE_NUMBER:
						try {
							this.getClass().getField(name).set(this, parser.getLong());
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

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public T updateOrCreate() {

		Transaction tx = dbService.beginTx();

		try {
			if (id == null) {
				underlyingNode = dbService.createNode();	
				id = underlyingNode.getId();
			}

			Field[] fields = this.getClass().getFields();

			for ( int i = 0; i < fields.length; i++ ){

				Field field = fields[i];
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
			tx.success();
		} catch (Exception e) {
			tx.failure();
			throw e;
		} finally {
			tx.close();
		}


		return (T) this;
	}

	public T load(Long id){

		this.id = id;
		Transaction tx = dbService.beginTx();

		try {
			underlyingNode = dbService.getNodeById(id);
			for(String key : underlyingNode.getPropertyKeys()){
				try {
					this.getClass().getField(key).set(this, underlyingNode.getProperty(key));
				} catch (IllegalArgumentException | IllegalAccessException
						| NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
			}
			tx.success();
		} catch (Exception e) {
			tx.failure();
			throw e;
		} finally {
			tx.close();
		}

		return (T) this;
	}

	public void setId(Long id) {
		this.id = id;
	}
}





















