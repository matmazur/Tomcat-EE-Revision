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

        resp.setContentType("text/html; charset=UTF-8");

        resp.getWriter().println(random.nextInt(100) + 1);
        System.out.println("Console says -  > random number was sent properly");



        String param1 = req.getParameter("value1");
        if (!param1.isEmpty()){
            resp.getWriter().println(param1);
            System.out.println(param1);

        }

        String [] param2 = req.getParameterValues("value2");
        if (param2.length>0){
            for (String s :param2){
                resp.getWriter().println(s);

                System.out.println(s);
            }
        }



    }
}
