package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/books";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;


    public static Connection getConnection() {
        return connection;
    }

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
            System.out.printf("Connected to database %s as user %s%n", URL, USER);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit() {
        try {
            if (connection != null) {
                connection.commit();
                System.out.println("Transaction committed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to commit transaction.", e);
        }
    }

    public static void rollback() {
        try {
            if (connection != null) {
                connection.rollback();
                System.out.println("Transaction rolled back.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to rollback transaction.", e);
        }
    }
}
