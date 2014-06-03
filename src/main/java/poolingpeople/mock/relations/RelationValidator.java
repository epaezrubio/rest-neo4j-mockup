/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poolingpeople.mock.relations;

/**
 *
 * @author alacambra
 */
public interface RelationValidator {

    String getMessage();
    Boolean validate(AbstractRelation relation);
    
}
