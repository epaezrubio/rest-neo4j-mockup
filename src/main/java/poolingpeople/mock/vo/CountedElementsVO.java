/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolingpeople.mock.vo;

        import poolingpeople.mock.entities.serializers.ISerializer;
        import poolingpeople.mock.entities.serializers.JSONSerializable;
        import poolingpeople.mock.vo.serializers.CountedElementsVOSerializer;
        import poolingpeople.mock.vo.serializers.CountedElementsVOSerializerQualifier;

        import javax.inject.Inject;

public class CountedElementsVO implements JSONSerializable<CountedElementsVO> {
//public class CollectionVO<T extends JSONSerializable> implements JSONSerializable<CollectionVO>
    CollectionVO collectionVO;
    ISerializer <CountedElementsVO> serializer;

    @Inject
    public CountedElementsVO(
            @CountedElementsVOSerializerQualifier ISerializer<CountedElementsVO> serializer,
            CollectionVO collection) {

        this.collectionVO = collection;
        this.serializer = serializer;
    }

    @Override
    public ISerializer<CountedElementsVO> getSerializer() {
        return new CountedElementsVOSerializer().setSerializableInstance(this);
    }

    public CollectionVO getCollection() {
        return collectionVO;
    }
}
