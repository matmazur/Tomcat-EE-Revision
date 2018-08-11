package servlets;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

@WebServlet("/random")
public class RandomNumberServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(RandomNumberServlet.class.getName());
    private Random random;



    public RandomNumberServlet() {
        super();
        logger.warning("Constructor");
    }

    @Override
    public void init() throws ServletException {
        random = new Random();
        logger.warning("Initialize");
    }

    @Override
    public void destroy() {

        logger.warning("Destroy");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println(random.nextInt(100) + 1);
        System.out.println("Console says -  > random number was sent properly");

        HttpSession session = req.getSession(true);

        session.setMaxInactiveInterval(60);

        if (session.getAttribute("string") != null) {
            resp.getWriter().println(session.getAttribute("string"));
        }


        User user = new User();
        user.setFirstName(req.getParameter("name"));
        user.setLastName(req.getParameter("lastName"));

        if (user.getLastName() != null && user.getFirstName() != null) {
            resp.getWriter().println("Hello " + user.getFirstName() + " " + user.getLastName() + "!");
        } else {
            if (session.getAttribute("user-ron") != null) {
                User ron = (User) session.getAttribute("user-ron");
                resp.getWriter().println("Hello " + ron.getFirstName() + " " + ron.getLastName() + "!");
            }
        }



    }



}

