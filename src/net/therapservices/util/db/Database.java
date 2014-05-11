package net.therapservices.util.db;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * UserDao: rifatul.islam
 * Date: 4/27/14
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Database {
    private static Database database;
    private static Connection connection;

    public static ResultSet executeQuery(String query, Object... values) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnectionManager.getConnection();
            statement = connection.prepareStatement(query);
            putValues(statement, values);
            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return resultSet;
    }

    public static void insertUpdateDeleteQuery(String query, Object... values) {
        PreparedStatement statement = null;

        try {
            connection = DbConnectionManager.getConnection();
            statement = connection.prepareStatement(query);
            putValues(statement, values);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void putValues(PreparedStatement statement, Object... values) throws SQLException {
        int i = 1;
        for (Object parameter : values) {
            if (parameter instanceof String) {
                statement.setString(i, (String) parameter);
            } else if (parameter instanceof Integer) {
                statement.setInt(i, (Integer) parameter);
            } else if (parameter instanceof Long) {
                statement.setLong(i, (Long) parameter);
            } else if (parameter instanceof Float) {
                statement.setFloat(i, (Float) parameter);
            } else if (parameter instanceof Double) {
                statement.setDouble(i, (Double) parameter);
            } else if (parameter instanceof Date) {
                statement.setDate(i, (Date) parameter);
            } else if (parameter instanceof Blob) {
                statement.setBlob(i, (Blob) parameter);
            }

            i++;
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
