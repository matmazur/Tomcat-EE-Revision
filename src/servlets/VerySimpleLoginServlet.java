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


        String username = req.getParameter("username");
        String password = req.getParameter("password");

       if (creds.containsKey(username)){
           if (creds.get(username).equals(password)){
               resp.sendRedirect("admin.jsp");
           }
       }
    }
}



