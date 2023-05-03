package main.service;

import java.sql.*;
import java.util.HashMap;

public class Database {
    private Connection connection;

    // Constructor to create a new database connection
    public Database(String host, String user, String password, String dbName) {
        try {
            String url = "jdbc:mysql://" + host + "/";
            connection = DriverManager.getConnection(url, user, password);
            createDatabaseIfNotExists(dbName);
            connection.setCatalog(dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new database if it doesn't exist
    private void createDatabaseIfNotExists(String dbName) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + dbName + "`");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query that returns a HashMap
    public HashMap<String, String> select(String sql) {
        HashMap<String, String> result = new HashMap<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String key = metaData.getColumnName(i);
                    String value = resultSet.getString(i);
                    result.put(key, value);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method to execute a query that performs an update
    public void query(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the database connection
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


