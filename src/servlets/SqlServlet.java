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
            req.getRequestDispatcher("/city-names-list.jsp").forward(req,resp);
        } else {
            resp.sendError(403);
        }
    }

    private List<City> getCityList(HttpServletResponse resp) throws IOException {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Statement statement;
        ResultSet resultSet ;
        Connection conn;
        List<City> cityList = new ArrayList<>();
        String sqlQuery = "Select * from city";


        try {
            conn = DriverManager.getConnection(dbPath, "root", "pass");
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            String cityName = null;
            int cityPopulation = 0;
            cityList = new ArrayList<>();
            while (resultSet.next()) {
                cityName = resultSet.getString("Name");
                cityPopulation = resultSet.getInt("Population");
                City city = new City(cityName, cityPopulation);
                cityList.add(city);
            }

            close(statement, resultSet, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
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



