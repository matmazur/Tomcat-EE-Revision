package filters;


import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


public class IpRequestFilter implements Filter {

    private Logger logger = Logger.getLogger(IpRequestFilter.class.getName());
    private String ipPattern;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ipPattern = filterConfig.getInitParameter("ipPattern");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        String reqIp = servletRequest.getRemoteAddr();
       logger.warning("Ip filter " + reqIp);

       if (reqIp.matches(ipPattern)){
           logger.warning("IP OK");
           filterChain.doFilter(servletRequest,servletResponse);
       }
       else {
           logger.warning("IP NOT OK");
           HttpServletResponse response = (HttpServletResponse) servletResponse;
           response.sendError(403);
       }

    }

    @Override
    public void destroy() {

    }
}
