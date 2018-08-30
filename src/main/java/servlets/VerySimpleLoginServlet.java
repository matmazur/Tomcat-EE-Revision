package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login-check")
public class VerySimpleLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map <String,String> creds = new HashMap<>();
        creds.put("admin","password");


        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");

       if (creds.containsKey(username) && creds.get(username).equals(password)){
               req.getSession(true).setAttribute("admin",true);
               resp.sendRedirect("admin.jsp");
       }
       else resp.sendRedirect("login-error.jsp");
    }
}



