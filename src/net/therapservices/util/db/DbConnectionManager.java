package net.therapservices.util.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.therapservices.util.file.PropManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * UserDao: rifatul.islam
 * Date: 4/27/14
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class DbConnectionManager {
    private static final String DRIVER_NAME;
    private static final String URL;
    private static final String USER_NAME;
    private static final String PASSWORD;
    private static Properties prop;
    private static DataSource dataSource;

    static {
        try {
            prop = PropManager.loadProperties("props/db.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER_NAME = prop.getProperty("jdbc.driver");
        URL = prop.getProperty("jdbc.url.address");
        USER_NAME = prop.getProperty("db.user");
        PASSWORD = prop.getProperty("db.password");
        dataSource = setupDataSource();
    }

    private static DataSource setupDataSource() {
        ComboPooledDataSource connectionPool = new ComboPooledDataSource();

        try {
            connectionPool.setDriverClass(DRIVER_NAME);
            connectionPool.setJdbcUrl(URL);
            connectionPool.setUser(USER_NAME);
            connectionPool.setPassword(PASSWORD);

            connectionPool.setMinPoolSize(5);
            connectionPool.setMaxPoolSize(20);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }


        return connectionPool;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
