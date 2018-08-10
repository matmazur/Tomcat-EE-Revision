package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        resp.getWriter().println(random.nextInt(100) + 1);
        System.out.println("Console says -  > random number was sent properly");

    }
}
