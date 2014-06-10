package poolingpeople.mock.vo.serializers;

import poolingpeople.mock.entities.serializers.AbstractSerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;
import poolingpeople.mock.entities.serializers.SerializationView;
import poolingpeople.mock.vo.CountedElementsVO;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Created by alacambra on 10.06.14.
 */
@CountedElementsVOSerializerQualifier
public class CountedElementsVOSerializer extends AbstractSerializer<CountedElementsVO> {

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
