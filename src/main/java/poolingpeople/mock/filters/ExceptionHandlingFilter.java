package poolingpeople.mock.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandlingFilter implements Filter {
    
    //@Inject : should be injected. Build a producer.
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        try{
           chain.doFilter(request, response);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            throw new WebApplicationException(e);
        }
        
    }
    
    private Exception clearException(Exception original){
        return original;
    }
    
    @Override
    public void destroy() {
        
    }
    
}
