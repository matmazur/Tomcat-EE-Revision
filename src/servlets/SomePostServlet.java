package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/post-servlet")
public class SomePostServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        HttpSession session = request.getSession(true);

        session.setAttribute("email", email);
        session.setAttribute("password", password);


        response.sendRedirect("/random");

    }
}
