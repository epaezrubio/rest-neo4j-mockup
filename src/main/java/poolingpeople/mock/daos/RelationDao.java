package poolingpeople.mock.daos;

import poolingpeople.mock.relations.AbstractRelation;

import javax.inject.Inject;

public class RelationDao{

    @Inject
    UserDao userDao;

    @Inject
    TaskDao taskDao;

    public void createRelation(AbstractRelation relation){
        relation.validateRelation();

    }

}
