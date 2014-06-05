package poolingpeople.mock.entities;

import javax.validation.constraints.NotNull;

import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;

public abstract class AbstractEntity<T> implements JSONSerializable<T> {

    protected Long id;

    protected ISerializer<T> serializer;

    protected AbstractEntity(ISerializer<T> serializer) {
        super();
        this.serializer = serializer;
        this.serializer.setSerializableInstance((T) this);
    }

    protected AbstractEntity() {
        super();
    }

    public Long getId() {
        return id;
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
