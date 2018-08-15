package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(false)!=null){
            System.out.println("Logout");

            req.getSession().invalidate();
            resp.sendRedirect("index.jsp");
        }else {
            System.out.println("no session found");
        }
    }
}
