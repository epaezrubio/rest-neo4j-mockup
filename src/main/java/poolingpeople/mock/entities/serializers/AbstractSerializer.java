package poolingpeople.mock.entities.serializers;

public abstract class AbstractSerializer<T> implements ISerializer<T>{
	
	protected T serializable;
	
	public ISerializer<T> setSerializableInstance(T serializable){
		this.serializable = serializable;
		return this;
	}
}

