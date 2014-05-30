package poolingpeople.mock.entities.serializers;

public interface ISerializer<T>{
	String serialize(T instance, SerializationView view);
	void load(T instance, String json);
}
