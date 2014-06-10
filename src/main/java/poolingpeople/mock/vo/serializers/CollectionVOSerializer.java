package poolingpeople.mock.vo.serializers;

import poolingpeople.mock.entities.serializers.AbstractSerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;
import poolingpeople.mock.entities.serializers.SerializationView;
import poolingpeople.mock.vo.CollectionVO;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 * Created by alacambra on 10.06.14.
 */
public class CollectionVOSerializer<R extends JSONSerializable> extends AbstractSerializer<CollectionVO<R>> {


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
