package org.linkdew.daopattern.connection;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final String USERNAME = "el";
    private static final String PASSWORD = "loverboy";
    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance() {
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            PGSimpleDataSource source = new PGSimpleDataSource();
            source.setDatabaseName("pois");
            source.setUser(USERNAME);
            source.setPassword(PASSWORD);
            connection = source.getConnection();
        } catch (SQLException e) {
            System.err.println("connection failed");
        }
        return connection;
    }
}
