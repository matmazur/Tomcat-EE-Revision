package servlets;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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

        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(true);
        session.setMaxInactiveInterval(60);


        writer.println("<!doctype html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");

        writer.println(random.nextInt(100) + 1);

        newLine(resp);

        if (session.getAttribute("string") != null) {
            writer.println(session.getAttribute("string"));
        }

        User user = setUserFromSession(req);

        printUserFromRequestIfPossible(writer, session, user);

        printUserFromFormIfExists(resp, writer, session);

        writer.println("<a href=\"form.html\"> link to form</a>");
        writer.println("</body>");
        writer.println("</html>");


    }

    private void printUserFromRequestIfPossible(PrintWriter writer, HttpSession session, User user) {
        if (user.getLastName() != null && user.getFirstName() != null) {
            writer.println("Hello " + user.getFirstName() + " " + user.getLastName() + "!");
        } else {
            if (session.getAttribute("user-ron") != null) {
                User ron = (User) session.getAttribute("user-ron");
                writer.println("Hello " + ron.getFirstName() + " " + ron.getLastName() + "!");
            }
        }
    }

    private User setUserFromSession(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter("name"));
        user.setLastName(req.getParameter("lastName"));
        return user;
    }

    private void printUserFromFormIfExists(HttpServletResponse resp, PrintWriter writer, HttpSession session) throws IOException {
        if (session.getAttribute("email") != null &&
                session.getAttribute("password") != null &&
                session.getAttribute("firstname") != null &&
                session.getAttribute("lastname") != null) {


            newLine(resp);
            writer.println("Hello sir " + session.getAttribute("firstname") + " " + session.getAttribute("lastname"));
            newLine(resp);
            writer.println("Your emails is  - " + session.getAttribute("email"));
            newLine(resp);
            writer.println("Your password is (wink wink)  - " + session.getAttribute("password"));

        }
    }


    private void newLine(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<br>");
    }
}

