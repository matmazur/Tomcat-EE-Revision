package servlets;

import util.DbConnector;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/users");
            conn = DbConnector.getInstance().getConnection();

            statement = conn.createStatement();
            String username =req.getParameter("username");
            String password =req.getParameter("password");
            // pass2" OR '1'='1'; --
            final String sqlQuery = "SELECT username, password FROM user WHERE "
                    +"username=" + "\"" + username + "\" "
                    +"AND "
                    +"password=" + "\"" + password + "\";";
            System.out.println(sqlQuery);
            resultSet = statement.executeQuery(sqlQuery);

            if(resultSet.next()) {
                String userFound = resultSet.getString("username");
               req.getSession().setAttribute("username", userFound);
                if("admin".equals(userFound)) {
                   req.getSession().setAttribute("privigiles", "all");
                } else{
                   req.getSession().setAttribute("privigiles", "view");
                }
            } else {
               req.getSession().setAttribute("username", "Nieznajomy");
               req.getSession().setAttribute("privigiles", "none");
            }
           req.getRequestDispatcher("result.jsp").forward(req, resp);
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

