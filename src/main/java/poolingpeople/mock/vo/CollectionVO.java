/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolingpeople.mock.vo;

import java.util.Collection;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import poolingpeople.mock.entities.serializers.AbstractSerializer;
import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;
import poolingpeople.mock.entities.serializers.SerializationView;

/**
 *
 * @author alacambra
 */
public class CollectionVO<T extends JSONSerializable> implements JSONSerializable<CollectionVO> {

    Collection<T> collection;

    public CollectionVO(Collection<T> collection) {
        this.collection = collection;
    }

    public Collection<T> getCollection() {
        return collection;
    }

    @Override
    public ISerializer<CollectionVO> getSerializer() {
        return new CollectionVO.Serializer().setSerializableInstance(this);
    }

    private static class Serializer<R extends JSONSerializable>
            extends AbstractSerializer<CollectionVO<R>> {
        

        @Override
        public JsonArray serializeArray(SerializationView view) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

            for (R element : serializable.getCollection()) {
                arrayBuilder.add(
                        element.getSerializer()
                        .serialize(SerializationView.PRIVATE));
            }

            return arrayBuilder.build();
        }

        @Override
        public CollectionVO load(String json) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public JsonObject serialize(SerializationView view) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
