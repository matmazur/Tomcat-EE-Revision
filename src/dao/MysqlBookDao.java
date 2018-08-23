package dao;

import model.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import utils.ConnectionProvider;
import utils.ResourceShutter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MysqlBookDao implements BookDao {

    private final static String CREATE = "INSERT INTO book(isbn, title, description) VALUES(:isbn, :title,:description);";
    private final static String READ = "SELECT isbn, title, description FROM book WHERE isbn = :isbn;";
    private final static String UPDATE = "UPDATE book SET isbn=:isbn, title=:title, description=:description WHERE isbn = :isbn;";
    private final static String DELETE = "DELETE FROM book WHERE isbn=:isbn;";


    private NamedParameterJdbcTemplate namedTemplate;

    public MysqlBookDao() {
        namedTemplate = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    public boolean create(Book book) {

        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(book);

        int rowsAffected = namedTemplate.update(CREATE, beanParamSource);
        boolean result = ifEnoughRowsAffectedReturnTrue(rowsAffected);
        return result;

    }

    public Book read(String isbn) {

        Book resultBook = null;

        SqlParameterSource source = new MapSqlParameterSource("isbn", isbn);
        List<Book> bookList = namedTemplate.query(READ,source,BeanPropertyRowMapper.newInstance(Book.class));
        resultBook = ifBookExist(resultBook, bookList);
        return resultBook;
    }


    public boolean update(Book book) {
        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(book);
        int rowsAffected = namedTemplate.update(UPDATE, beanParamSource);
        boolean result = ifEnoughRowsAffectedReturnTrue(rowsAffected);
        return result;
    }

    public boolean delete(Book book) {

        SqlParameterSource source = new MapSqlParameterSource("isbn", book.getIsbn());
        int rowsAffected = namedTemplate.update(DELETE, source);
        boolean result = ifEnoughRowsAffectedReturnTrue(rowsAffected);
        return result;
    }

    private Book ifBookExist(Book resultBook, List<Book> bookList) {
        if (!bookList.isEmpty()&&bookList.get(0) != null) {
            resultBook = bookList.get(0);
        }
        return resultBook;
    }

    private boolean ifEnoughRowsAffectedReturnTrue(int rowsAffected) {
        boolean result = false;
        if (rowsAffected > 0) {
            result = true;
        }
        return result;
    }

}
