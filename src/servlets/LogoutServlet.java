package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


public class LogoutServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(false)!=null){
            System.out.println("Logout");

            req.getSession().invalidate();
            logger.warning("session was invalidated");
            resp.sendRedirect("index.jsp");
        }else {
            logger.warning("session not found");

        }
    }
}
