package main.service;

import java.sql.*;
import java.util.*;

public class Database {
    private Connection connection = null;
    private String host;
    private String user;
    private String password;
    private String dbName;

    public Database(String host, String user, String password, String dbName) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.dbName = dbName;
        connectAndInitializeDatabase();
    }

    private void connectAndInitializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306?useSSL=false", user, password);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            connection.setCatalog(dbName);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> select(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<Map<String, Object>> resultList = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }

            return resultList;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void query(String query) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


