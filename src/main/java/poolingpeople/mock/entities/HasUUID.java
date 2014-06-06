/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poolingpeople.mock.entities;

/**
 *
 * @author alacambra
 */
public interface HasUUID<T> {
    public T setUuid(String uuid);
    public String getUuid();
}
