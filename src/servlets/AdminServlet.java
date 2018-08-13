package servlets;


import com.sun.javafx.event.RedirectedEvent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin-servlet")
public class AdminServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");


        if (username.equals("admin")) {

            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<head><title>Hello dear admin</title></head>");
            writer.println("<body>");
            writer.println("<h1>Hello " + username + " Gonzales</h1>");
            writer.println("</body>");
            writer.println("</html>");

        } else {
            req.getRequestDispatcher("/login-servlet").include(req, resp);
            resp.getWriter().println("You are not the admin");
        }
    }
}
