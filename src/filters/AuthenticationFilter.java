package filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationFilter implements Filter {
    private Logger logger = Logger.getLogger(IpRequestFilter.class.getName());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.warning("Auth filter");

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession(false);

        if (session!=null&& session.getAttribute("username")!=null){
            logger.warning("session + user valid");
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            logger.warning("session or user not valid");
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("login.jsp");
        }


    }

    @Override
    public void destroy() {

    }
}
