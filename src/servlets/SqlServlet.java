package servlets;

import beans.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;


@WebServlet("/sql-servlet")
public class SqlServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String param = req.getParameter("value");

    if (param.equals("all")){


        final String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<City> cities= null;
        final String dbPath = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Connection conn = DriverManager.getConnection(dbPath, "root", "pass");
            Statement statement = conn.createStatement();

            String sqlQuery = "Select * from city";

            ResultSet result=statement.executeQuery(sqlQuery);

                    while (result.next()){
                        resp.getWriter().println(result.getString("Name")+" " + result.getInt("Population"));
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



    }
}

