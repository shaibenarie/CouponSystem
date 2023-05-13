package main.service;

import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {
    private static ConnectionPool _instance;
    private final Stack<Connection> _connections;

    public ConnectionPool() throws IllegalSingletonInitializationException {
        if (_instance != null) throw new IllegalSingletonInitializationException();
        _connections = new Stack<>();
    }

    public void restoreConnection(Connection connection){
        _connections.push(connection);
        notify();
    }

    public Connection getConnection() throws InterruptedException{
        if (_connections.isEmpty()){
            wait();
        }

        return _connections.pop();
    }

    public void closeAllConnections() throws SQLException {
        for (Connection connection : _connections) {
            connection.close();
        }
    }

    public static ConnectionPool getInstance() throws IllegalSingletonInitializationException {
        if (_instance == null){
            return new ConnectionPool();
        }

        return _instance;
    }
}
