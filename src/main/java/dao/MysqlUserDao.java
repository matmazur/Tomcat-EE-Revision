package dao;

import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import utils.ConnectionProvider;

import java.util.List;

public class MysqlUserDao implements UserDao {

    private final static String CREATE = "INSERT INTO user(pesel, firstname,lastname) VALUES(:pesel, :firstname, :lastname);";
    private final static String READ = "SELECT pesel, firstname,lastname FROM user WHERE pesel = :pesel;";
    private final static String UPDATE = "UPDATE user SET pesel=:pesel, firstname=:firstname, lasname=:lastname WHERE pesel = :pesel;";
    private final static String DELETE = "DELETE FROM user WHERE pesel=:pesel;";


    NamedParameterJdbcTemplate template;


    public MysqlUserDao() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    public boolean create(User user) {
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);

        int rowsAffected = template.update(CREATE, source);
        boolean result = ifEnoughRowsAffectedReturnTrue(rowsAffected);
        return result;

    }

    @Override
    public User read(String pesel) {

        User resultUser = null;
        SqlParameterSource source = new MapSqlParameterSource("pesel", pesel);
        List<User> bookList = template.query(READ, source, BeanPropertyRowMapper.newInstance(User.class));

        resultUser = ifUserExists(resultUser, bookList);
        return resultUser;
    }

    @Override
    public boolean update(User user) {
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);

        int rowsAffected = template.update(UPDATE, source);
        boolean result = ifEnoughRowsAffectedReturnTrue(rowsAffected);
        return result;
    }

    @Override
    public boolean delete(User user) {
        SqlParameterSource source = new MapSqlParameterSource("pesel", user.getPesel());

        int rowsAffected = template.update(DELETE, source);
        boolean result = ifEnoughRowsAffectedReturnTrue(rowsAffected);
        return result;
    }

    private User ifUserExists(User resultUser, List<User> userList) {
        if (!userList.isEmpty() && userList.get(0) != null) {
            resultUser = userList.get(0);
        }
        return resultUser;
    }

    private boolean ifEnoughRowsAffectedReturnTrue(int rowsAffected) {
        boolean result = false;
        if (rowsAffected > 0) {
            result = true;
        }
        return result;
    }

}
