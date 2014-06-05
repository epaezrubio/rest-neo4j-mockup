/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poolingpeople.mock.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


/**
 *
 * @author alacambra
 */

//@ApplicationScoped
public class JaxRsClientProducer {
    
//    @Produces
    public Client getClient(){
        return ClientBuilder.newClient();
    }
}
