/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolingpeople.mock.vo;

import java.util.Collection;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import poolingpeople.mock.entities.serializers.AbstractSerializer;
import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;
import poolingpeople.mock.entities.serializers.SerializationView;

public class CountedElementsVO<T extends JSONSerializable> implements JSONSerializable<CountedElementsVO> {

    CollectionVO<T> collectionVO;

    public CountedElementsVO(CollectionVO<T> collection) {
        this.collectionVO = collection;
    }

    @Override
    public ISerializer<CountedElementsVO> getSerializer() {
        return new CountedElementsVO.Serializer().setSerializableInstance(this);
    }

    public CollectionVO<T> getCollection() {
        return collectionVO;
    }

    private static class Serializer<R extends JSONSerializable>
            extends AbstractSerializer<CountedElementsVO<R>> {

        @Override
        public JsonObject serialize(SerializationView view) {
            JsonObjectBuilder builder = Json.createObjectBuilder();

            builder.add("total", 
                    this.serializable.getCollection().getCollection().size());
            builder.add("object", 
                    this.serializable.getCollection()
                            .getSerializer().serialize(view));
           
            return builder.build();
        }

        @Override
        public CountedElementsVO load(String json) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public JsonArray serializeArray(SerializationView view) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
