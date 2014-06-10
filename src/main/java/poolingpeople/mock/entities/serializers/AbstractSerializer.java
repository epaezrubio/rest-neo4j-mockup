package poolingpeople.mock.entities.serializers;

import javax.json.JsonArray;
import javax.json.JsonObject;

public abstract class AbstractSerializer<T> implements ISerializer<T> {

    protected T serializable;

    @Override
    public ISerializer<T> setSerializableInstance(T serializable) {
        this.serializable = serializable;
        return this;
    }

    @Override
    public JsonArray serializeArray() {
        return serializeArray(null);
    }

    @Override
    public JsonObject serialize() {
        return serialize(null);
    }
}
