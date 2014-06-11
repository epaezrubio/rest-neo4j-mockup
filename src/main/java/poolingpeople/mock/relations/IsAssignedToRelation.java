/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poolingpeople.mock.relations;

import org.apache.commons.lang3.tuple.ImmutablePair;
import poolingpeople.mock.entities.Task;
import poolingpeople.mock.entities.User;

/**
 *
 * @author alacambra
 */
public class IsAssignedToRelation extends Neo4jRelation<IsAssignedToRelation>{

    public IsAssignedToRelation(){
        validPairs.add(new ImmutablePair(Task.class, User.class));
    }
    
    @Override
    public String name() {
        return "isAssignedTo";
    }
    
}
