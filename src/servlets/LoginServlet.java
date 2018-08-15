package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private static String USERNAME = "admin";
    private static String PASSWORD = "pass";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String reqUsername = req.getParameter("username");
        String reqPassword = req.getParameter("password");


        if (USERNAME.equals(reqUsername)&&PASSWORD.equals(reqPassword)){
            req.getSession(true).setAttribute("username",reqUsername);
        }
        response.sendRedirect("admin.jsp" +
                "");

    }
}