package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
    public static int insert(String name, String country, String district,
                             int population) {
        int rowsAffected = 0;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionProvider.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO city(Name, CountryCode, District, Population) "
                    + "VALUES("
                    + "\""+name+"\""
                    + ","
                    + "\""+country+"\""
                    + ","
                    + "\""+district+"\""
                    + ","
                    + "\""+population+"\""
                    + ");";
            rowsAffected = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(stmt, null, conn);
        }
        return rowsAffected;
    }

    public static int delete(String name) {
        int rowsAffected = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionProvider.getConnection();
            stmt = conn.createStatement();
            String selectQuery = "SELECT ID FROM city WHERE " + ("Name = " + "\""+name+"\"");
            resultSet = stmt.executeQuery(selectQuery);
            if(resultSet.next()) {
                String deleteQuery = "DELETE FROM city WHERE ID="+resultSet.getInt(1);
                rowsAffected = stmt.executeUpdate(deleteQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(stmt, resultSet, conn);
        }
        return rowsAffected;
    }

    private static void releaseResources(Statement st, ResultSet rst, Connection conn) {
        try {
            if(st != null && !st.isClosed())
                st.close();
            if(rst != null && !rst.isClosed())
                rst.close();
            if(conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
