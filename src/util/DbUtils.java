package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.ConnectionPoolDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbUtils {

    private static DbUtils dbUtils;
    private static Logger logger = Logger.getLogger(DbUtils.class.getName());

    private ComboPooledDataSource connectionPool;


    private DbUtils() throws PropertyVetoException {
        connectionPool = new ComboPooledDataSource();

        connectionPool.setDriverClass("com.mysql.jdbc.Driver");
        connectionPool.setJdbcUrl("jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        connectionPool.setUser("root");
        connectionPool.setPassword("pass");


        //POOL SIZES//
        connectionPool.setInitialPoolSize(5);
        connectionPool.setMinPoolSize(5);
        connectionPool.setMaxPoolSize(20);
        connectionPool.setMaxIdleTime(3600);
    }

    public Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }


    public void close(ComboPooledDataSource c) {
        c.close();
    }


    public static DbUtils getInstance() {
        if (dbUtils == null) {
            try {
                dbUtils = new DbUtils();
            } catch (PropertyVetoException e) {
                logger.severe("couldn't create instance of DbUtils");
            }
        }
        return dbUtils;
    }
}
