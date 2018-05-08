package hu.restoffice.gateway.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import hu.restoffice.gateway.properties.ServiceProperties;

/**
 *
 */
@Component
public class GatewayInboundCorrelationFilter extends ZuulFilter {

    private static final Logger log = LogManager.getLogger();
    @Autowired
    private ServiceProperties properties;


    /*
     * (non-Javadoc)
     *
     * @see com.netflix.zuul.IZuulFilter#shouldFilter()
     */
    @Override
    public boolean shouldFilter() {
        return properties.isCorreletaionFilterEnabled();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.netflix.zuul.IZuulFilter#run()
     */
    @Override
    public Object run() throws ZuulException {
        setCorrelationId();

        return null;

    }


    private void setCorrelationId() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String id = java.util.UUID.randomUUID().toString();
        ctx.addZuulRequestHeader("Correlation-id", id);
        log.info("Request Correlation-id :" + id + " to: " + ctx.getRequest().getContextPath());

    }

    /*
     * (non-Javadoc)
     *
     * @see com.netflix.zuul.ZuulFilter#filterType()
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */
    @Override
    public int filterOrder() {
        return 100000;
    }

}
