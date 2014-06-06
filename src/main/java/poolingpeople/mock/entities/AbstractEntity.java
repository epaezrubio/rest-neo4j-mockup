package poolingpeople.mock.entities;

import javax.enterprise.event.Observes;
import javax.validation.constraints.NotNull;

import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;

public abstract class AbstractEntity<T>
implements JSONSerializable<T>, HasUUID<T> {
    
    protected String id = "unset";
    
    protected ISerializer<T> serializer;
    
    protected AbstractEntity(ISerializer<T> serializer) {
        super();
        this.serializer = serializer;
        this.serializer.setSerializableInstance((T) this);
    }
    
    protected AbstractEntity() {
        super();
    }
    
    @Deprecated
    public String getId() {
        return getUuid();
    }
    
    @Override
    public T setUuid(String uuid) {
        this.id = uuid;
        return (T) this;    
    }
    
    @Override
    public String getUuid() {
        return id;
    }
    
    @Deprecated
    public T setId(@NotNull String uuid) {
        return setUuid(uuid);
    }
    
    @Override
    public ISerializer<T> getSerializer() {
        return serializer;
    }
}
