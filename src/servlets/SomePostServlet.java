package servlets;

import beans.AdvancedUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/post-servlet")
public class SomePostServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        HttpSession session = request.getSession(true);


        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname);
        session.setAttribute("email", email);
        session.setAttribute("password", password);


        if (checkIfNotNull(firstname,lastname,email,password)) {

            List<AdvancedUser> users = (List<AdvancedUser>) session.getAttribute("users");
            if (users==null){
                session.setAttribute("users",new ArrayList<>());
                users = new ArrayList<>();
            }

            AdvancedUser currentUser = new AdvancedUser(firstname,lastname,email,password);

            //PURGE
            session.setAttribute("firstname",null);
            session.setAttribute("lastname",null);
            session.setAttribute("email",null);
            session.setAttribute("password",null);

            users.add(currentUser);
            session.setAttribute("users",users);




        response.sendRedirect("/");



    }


}

    private boolean checkIfNotNull (String ... args){

        for (String s:args){
            if (s==null){
                return false;
            }
        }
        return true;
    }
}
