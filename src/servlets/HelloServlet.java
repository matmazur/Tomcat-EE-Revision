package servlets;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.getWriter().println("GREETINGS MASSIVE");
        resp.getWriter().println("Tomcat works rather proper way");
        resp.getWriter().println("Test do I have to even reload anything");
        resp.getWriter().println("Test2: I don't even have to rebuild a thing. Not so shabby at all. Test 3?");

        HttpSession session = req.getSession(true);

        req.getSession().setAttribute("string", new String("Jesus christ!"));

        session.setAttribute("user-ron", new User("Ron", "Swanson"));


    }
}
