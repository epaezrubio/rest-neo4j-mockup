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
import poolingpeople.mock.vo.serializers.CollectionVOSerializerQualifier;

import javax.inject.Inject;

/**
 *
 * @author alacambra
 */
public class CollectionVO implements JSONSerializable<CollectionVO> {

    Collection<? extends JSONSerializable> collection;

    ISerializer<CollectionVO> serializer;

    @Inject
    public CollectionVO(@CollectionVOSerializerQualifier ISerializer<CollectionVO> serializer) {
        this.serializer = serializer.setSerializableInstance(this);
    }

    public Collection<? extends JSONSerializable> getCollection() {
        return collection;
    }

    @Override
    public ISerializer<CollectionVO> getSerializer() {
        return serializer;
    }

    public CollectionVO setCollection(Collection<? extends JSONSerializable> collection) {
        this.collection = collection;
        return this;
    }
}
