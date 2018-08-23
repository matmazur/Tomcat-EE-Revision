package dao;

import model.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import utils.ConnectionProvider;
import utils.ResourceShutter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MysqlBookDao implements BookDao {

    private final static String CREATE = "INSERT INTO book(isbn, title, description) VALUES(:isbn, :title,:description);";
    private final static String READ = "SELECT isbn, title, description FROM book WHERE isbn = ?;";
    private final static String UPDATE = "UPDATE book SET isbn=?, title=?, description=? WHERE isbn = ?;";
    private final static String DELETE = "DELETE FROM book WHERE isbn=?;";



    private NamedParameterJdbcTemplate namedTemplate;

    public MysqlBookDao(){
        namedTemplate = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    public boolean create(Book book) {

        Map<String,Object> paramMap = new HashMap<>();

        paramMap.put("isbn",book.getIsbn());
        paramMap.put("title",book.getTitle());
        paramMap.put("description",book.getDescription());

        namedTemplate.update(CREATE,paramMap);
        return true;


    }

    public Book read(String isbn) {





        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        Book resultBook = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(READ);
            prepStmt.setString(1, isbn);
            resultSet = prepStmt.executeQuery();
            if (resultSet.next()) {
                resultBook = new Book();
                resultBook.setIsbn(resultSet.getString("isbn"));
                resultBook.setTitle(resultSet.getString("title"));
                resultBook.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, resultSet, conn);
        }
        return resultBook;
    }

    public boolean update(Book book) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(UPDATE);
            prepStmt.setString(1, book.getIsbn());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setString(3, book.getDescription());
            prepStmt.setString(4, book.getIsbn());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }

    public boolean delete(Book book) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DELETE);
            prepStmt.setString(1, book.getIsbn());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }


    private void releaseResources(PreparedStatement prepStmt, ResultSet res, Connection conn) {
        ResourceShutter.close(prepStmt, res, conn);
    }

    private class MysqlBookMapper implements org.springframework.jdbc.core.RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book();
            book.setIsbn(resultSet.getString("isbn"));
            book.setTitle(resultSet.getString("title"));
            book.setDescription(resultSet.getString("description"));

            return book;

        }
    }
}
