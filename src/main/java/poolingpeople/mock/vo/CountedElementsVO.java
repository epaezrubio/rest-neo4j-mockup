/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolingpeople.mock.vo;

        import poolingpeople.mock.entities.serializers.ISerializer;
        import poolingpeople.mock.entities.serializers.JSONSerializable;
        import poolingpeople.mock.vo.serializers.CountedElementsVOSerializer;

public class CountedElementsVO<T extends JSONSerializable> implements JSONSerializable<CountedElementsVO> {
//public class CollectionVO<T extends JSONSerializable> implements JSONSerializable<CollectionVO>
    CollectionVO<T> collectionVO;

    public CountedElementsVO(CollectionVO<T> collection) {
        this.collectionVO = collection;
    }

    @Override
    public ISerializer<CountedElementsVO> getSerializer() {
        return new CountedElementsVOSerializer().setSerializableInstance(this);
    }

    public CollectionVO<T> getCollection() {
        return collectionVO;
    }
}
