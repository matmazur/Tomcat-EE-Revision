package servlets;

import beans.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/sql-servlet")
public class SqlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param = req.getParameter("value");

        if (param.equals("all")) {

            List<City> cities= getCityList(resp);
            req.setAttribute("Cities",cities);
            req.getRequestDispatcher("/cities-list.jsp").forward(req,resp);

        } if (param.equals("names")) {
            List<String> names= getCityList(resp)
                    .stream()
                    .map(x->x.getName())
                    .collect(Collectors.toList());
            req.setAttribute("Cities",names);
            req.getRequestDispatcher("/cities-list.jsp").forward(req,resp);
        } else {
            resp.sendError(403);
        }
    }

    private List<City> getCityList(HttpServletResponse resp) throws IOException {

        Statement statement;
        ResultSet result ;
        Connection conn;
        List<City> cities = new ArrayList<>();

        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String dbPath = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(dbPath, "root", "pass");
            statement = conn.createStatement();

            String sqlQuery = "Select * from city";

            result = statement.executeQuery(sqlQuery);

            while (result.next()) {
                String cityName = result.getString("Name");
                int population = result.getInt("Population");
                if (cityName!=null) {
                    cities.add(new City(cityName, population));
                }
            }

            close(statement, result, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }


    private void close(Statement statement, ResultSet result, Connection conn) throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (result != null) {
            result.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}



