package poolingpeople.mock.entities.serializers;

public interface JSONSerializable<T> {
	ISerializer<T> getSerializer();
}
