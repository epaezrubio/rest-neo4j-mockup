package poolingpeople.mock.entities.serializers;

public interface ISerializer<T>{
	String serialize(SerializationView view);
        String serialize();
	T load(String json);
	ISerializer<T> setSerializableInstance(T serializable);
}
