package poolingpeople.mock.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import poolingpeople.mock.dbutils.Neo4jRestApiAdapter;
import poolingpeople.mock.relations.Neo4jRelation;

public abstract class AbstractDao<T> {

    @Transient
    protected Neo4jRestApiAdapter restAPI = new Neo4jRestApiAdapter();
    private String currentClass;
    
    @Inject
    Instance<T> instance;
    

    protected AbstractDao(String currentClass) {
        this.currentClass = currentClass;
        currentClass
                = currentClass.split("\\.")[currentClass.split("\\.").length - 1];
    }

    public T loadById(@NotNull String uuid) {
        return instance.get();
    }

    public void update(@NotNull T model, @NotNull String uuid) {
        restAPI.updateNode(model, "");
    }

    public T create(@NotNull T model) {
        restAPI.createNodeWithLabel(model, currentClass);
        //TODO set the created id
        return model;
    }

    public void delete(@NotNull String uuid) {

    }

    protected void delete(@NotNull Long id) {

    }

    public void deleteAll() {

    }

    public void relate(Neo4jRelation relation) {

    }
    
    public Collection<T> list(){
        List<T> list = new ArrayList<>();
        list.add(instance.get());
        list.add(instance.get());
        
        return list;
    }

}
