package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String userParam = req.getParameter("username");
        String username;


        if (userParam==null || userParam.isEmpty()) {
            username= (String) req.getSession(true).getAttribute("username");
        }else {
            req.getSession(true).setAttribute("username",userParam);
            username= (String) req.getSession(true).getAttribute("username");
        }


        if (username==null||username.isEmpty()) {
             username = getServletConfig().getInitParameter("defaultUsername");
        }


        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Hello " + username + "</title></head>");
        writer.println("<body>");
        writer.println("<h1>Hello " + username + "</h1>");
        writer.println("</body>");
        writer.println("</html>");

    }
}