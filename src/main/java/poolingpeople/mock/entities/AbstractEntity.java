package poolingpeople.mock.entities;

import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Transaction;

import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;


public abstract class AbstractEntity<T> implements JSONSerializable<T>
{
	
	@Inject
	protected org.neo4j.graphdb.GraphDatabaseService dbService;
	protected org.neo4j.graphdb.Node underlyingNode;
	protected Long id;
	
	protected ISerializer<T> serializer;

	protected AbstractEntity(ISerializer<T> serializer){
		super();
		this.serializer = serializer;
		this.serializer.setSerializableInstance((T) this);
	}

	public Long getId() {
		return id;	
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

	public T setId(@NotNull Long id) {
		this.id = id;
		return (T) this;
	}
	
	@Override
	public ISerializer<T> getSerializer() {
		return serializer;
	}
}





















