/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poolingpeople.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author alacambra
 */
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException>{

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Response toResponse(WebApplicationException exception) {
        ObjectMapper mapper = new ObjectMapper();
        try {

            logger.error("", exception.getCause());
            return  Response.fromResponse(exception.getResponse())
                    .entity(mapper.writeValueAsString(exception.getStackTrace()))
                    .type(MediaType.APPLICATION_JSON).build();

        } catch (JsonProcessingException ex) {
            throw exception;
        }
    }
    
}
