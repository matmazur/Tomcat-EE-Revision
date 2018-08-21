package servlets;

import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller-servlet")
public class ControllerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String district = req.getParameter("district");
        String populationString = req.getParameter("population");

        int population = 0;
        if (populationString != null && !populationString.equals("")) {
            try {
                population = Integer.parseInt(populationString);
            } catch (NumberFormatException e) {
                System.out.println("populationString was not a proper number format");
            }
        }

        String option = req.getParameter("option");
        String message = null;


        if (option.equals("add")) {
            DbUtil.insert(name, country, district, population);
            message = name + " city was added to the database";
        } else if (option.equals("delete")) {
            DbUtil.delete(name);
            message = name + " city was deleted from the database";
        }

        req.setAttribute("message",message);;
        req.getRequestDispatcher("message.jsp").forward(req,resp);

    }


}
