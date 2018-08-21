package servlets;

import util.ConnectionProvider;
import util.DbConnector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/users");
            conn = ds.getConnection();

            statement = conn.createStatement();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // pass2" OR '1'='1'; --
            final String sqlQuery = "SELECT username, password FROM users WHERE "
                    +"username=" + "\"" + username + "\" "
                    +"AND "
                    +"password=" + "\"" + password + "\";";
            System.out.println(sqlQuery);
            resultSet = statement.executeQuery(sqlQuery);

            if(resultSet.next()) {
                String userFound = resultSet.getString("username");
                request.getSession().setAttribute("username", userFound);
                if("admin".equals(userFound)) {
                    request.getSession().setAttribute("privileges", "all");
                } else{
                    request.getSession().setAttribute("privileges", "view");
                }
            } else {
                request.getSession().setAttribute("username", "Noname");
                request.getSession().setAttribute("privileges", "none");
            }
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
