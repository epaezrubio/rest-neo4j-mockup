/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolingpeople.mock.vo;

import java.util.Collection;

import poolingpeople.mock.entities.serializers.ISerializer;
import poolingpeople.mock.entities.serializers.JSONSerializable;
import poolingpeople.mock.vo.serializers.CollectionVOSerializer;

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
        return new CollectionVOSerializer().setSerializableInstance(this);
    }
}
