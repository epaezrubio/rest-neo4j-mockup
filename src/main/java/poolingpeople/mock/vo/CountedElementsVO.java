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
    CollectionVO collectionVO;
    ISerializer <CountedElementsVO> serializer;

    @Inject
    public CountedElementsVO(@CountedElementsVOSerializerQualifier ISerializer<CountedElementsVO> serializer) {
        this.serializer = serializer.setSerializableInstance(this);
    }

    public CountedElementsVO setCollectionVO(CollectionVO collectionVO) {
        this.collectionVO = collectionVO;
        return this;
    }

    @Override
    public ISerializer<CountedElementsVO> getSerializer() {
        return serializer;
    }

    public CollectionVO getCollection() {
        return collectionVO;
    }
}
