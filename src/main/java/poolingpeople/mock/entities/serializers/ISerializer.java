package poolingpeople.mock.entities.serializers;

import javax.json.JsonArray;
import javax.json.JsonObject;

public interface ISerializer<T> {

    JsonObject serialize(SerializationView view);

    JsonObject serialize();

    JsonArray serializeArray(SerializationView view);

    JsonArray serializeArray();

    T load(String json);

    ISerializer<T> setSerializableInstance(T serializable);
}
