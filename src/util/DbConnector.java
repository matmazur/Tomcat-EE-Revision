package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DbConnector {

    private static DbConnector dbUtils;
    private static Logger logger = Logger.getLogger(DbConnector.class.getName());

    private ComboPooledDataSource connectionPool;
private static final String SETTINGS_FILE="properties.config";

    private DbConnector() throws PropertyVetoException, IOException {
        connectionPool = new ComboPooledDataSource();

        connectionPool.setDriverClass(getSettings().getProperty("driverClass"));
        connectionPool.setJdbcUrl(getSettings().getProperty("jdbcUrl"));
        connectionPool.setUser(getSettings().getProperty("user"));
        connectionPool.setPassword(getSettings().getProperty("password"));


        //POOL SIZES//
        connectionPool.setInitialPoolSize(5);
        connectionPool.setMinPoolSize(5);
        connectionPool.setMaxPoolSize(20);
        connectionPool.setMaxIdleTime(3600);
    }

    public Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }


    public void close() {
        connectionPool.close();
    }

    public static DbConnector getInstance() {
        if (dbUtils == null) {
            try {
                dbUtils = new DbConnector();
            } catch (PropertyVetoException e) {
                logger.severe("couldn't create instance of DbConnector");
            } catch (IOException e) {
               logger.severe("IO Exception  - > check settings method");
            }
        }
        return dbUtils;
    }

    private Properties getSettings() throws IOException {

        Properties settings = new Properties();
        settings.load(Thread.currentThread()
        .getContextClassLoader()
        .getResource(SETTINGS_FILE)
        .openStream());

        return settings;
    }

}
