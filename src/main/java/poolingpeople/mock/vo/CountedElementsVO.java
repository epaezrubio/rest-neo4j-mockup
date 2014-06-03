/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolingpeople.mock.vo;

import java.util.Collection;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import poolingpeople.mock.entities.serializers.AbstractSerializer;
import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;
import poolingpeople.mock.entities.serializers.SerializationView;

public class CountedElementsVO<T extends JSONSerializable> implements JSONSerializable<CountedElementsVO> {

    Collection<T> collection;

    public CountedElementsVO(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public ISerializer<CountedElementsVO> getSerializer() {
        return new Serializer();
    }

    public Collection<T> getCollection() {
        return collection;
    }

    private static class Serializer<R extends JSONSerializable>
            extends AbstractSerializer<CountedElementsVO<R>> {

        @Override
        public String serialize(SerializationView view) {
            JsonObjectBuilder builder = Json.createObjectBuilder();

            builder.add("total", this.serializable.getCollection().size());
            builder.add("object", this.serializable
                    .getCollection().iterator().next()
                    .getSerializer().serialize(view));

            return builder.build().toString();
        }

        @Override
        public CountedElementsVO load(String json) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
