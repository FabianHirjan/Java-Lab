package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final HikariDataSource dataSource;
    // Configurațiile HikariCP
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/books");
        config.setUsername("postgres");
        config.setPassword("password");

        // Configurație suplimentară a pool-ului (opțională)
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(20);
        config.setConnectionTimeout(30000); // 30 de secunde

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Tratare eroare închidere conexiune
                e.printStackTrace();
            }
        }
    }

    public static void commit() {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                connection.setAutoCommit(false); // Disable auto-commit
                connection.commit();
                System.out.println("Transaction committed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to commit transaction.", e);
        }
    }

    public static void rollback() {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                connection.setAutoCommit(false); // Disable auto-commit
                connection.rollback();
                System.out.println("Transaction rolled back.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to rollback transaction.", e);
        }
    }


    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
