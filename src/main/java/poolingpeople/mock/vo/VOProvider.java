package poolingpeople.mock.vo;

import org.apache.commons.lang3.exception.ContextedRuntimeException;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by alacambra on 10.06.14.
 */
public class VOProvider {

    @Inject
    Instance<CollectionVO> collectionVOInstance;

    @Inject
    Instance<CountedElementsVO> countedElementsVOInstance;

    public <T> T getInstance(Class<T> clazz){
        if ( clazz.isAssignableFrom(CollectionVO.class) ){
            return (T) collectionVOInstance.get();
        }

        if ( clazz.isAssignableFrom(CountedElementsVO.class) ){
            return (T) countedElementsVOInstance.get();
        }

        throw new ContextedRuntimeException("Instance provider not found")
                .addContextValue("given class", clazz.getCanonicalName());
    }
}
