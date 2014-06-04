package poolingpeople.mock.daos;

import java.lang.reflect.ParameterizedType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.neo4j.graphdb.Node;
import org.neo4j.rest.graphdb.batch.CypherResult;
import poolingpeople.mock.dbutils.Neo4jRestApiAdapter;
import poolingpeople.mock.relations.Neo4jRelation;

public abstract class AbstractDao<T> {

    @Transient
    protected Neo4jRestApiAdapter restAPI = new Neo4jRestApiAdapter();
    private String currentClass;

    protected AbstractDao() {
        currentClass = ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0].toString();
        currentClass
                = currentClass.split("\\.")[currentClass.split("\\.").length - 1];
    }

    public T loadById(@NotNull String uuid) {
        CypherResult result = restAPI.query("", null);
        return null;
    }

    protected T loadByNode(@NotNull Node node) {
        return null;
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

}
