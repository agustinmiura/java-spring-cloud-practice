package ar.com.miura.netflixzuulapigatewayserver.logging;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private static final Logger LOGGER= LoggerFactory.getLogger(ZuulLoggingFilter.class);
    private static final String FILTER_TYPE = "pre";
    private static final int FILTER_ORDER = 1;

    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        var request= RequestContext.getCurrentContext().getRequest();
        LOGGER.debug(" Request -> {} , Request Uri -> {} ", request, request.getRequestURI());
        return null;
    }
}
