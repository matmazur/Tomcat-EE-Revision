package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {

    private static String USERNAME = "admin";
    private static String PASSWORD = "pass";
    private Logger logger = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String reqUsername = req.getParameter("username");
        String reqPassword = req.getParameter("password");


        if (USERNAME.equals(reqUsername)&&PASSWORD.equals(reqPassword)){
            req.getSession(true).setAttribute("username",reqUsername);
            logger.warning("parameters are equal, login proceeds");
        }
        response.sendRedirect("admin.jsp");

    }
}