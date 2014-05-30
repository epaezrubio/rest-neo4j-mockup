package poolingpeople.mock.entities.serializers;

public interface ISerializer<T>{
	String serialize(SerializationView view);
	T load(String json);
	ISerializer<T> setSerializableInstance(T serializable);
}
