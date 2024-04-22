package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDao {
    public void create(String name) throws SQLException {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("INSERT INTO authors (name) VALUES (?)")) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
    }

    public void deleteall() throws SQLException {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("DELETE FROM authors")) {
            statement.executeUpdate();
            autoIncrementReset();
        }
    }

    private void autoIncrementReset() {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("ALTER SEQUENCE authors_id_seq RESTART WITH 1")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void findByName(String name) {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM authors WHERE name = ?")) {
            statement.setString(1, name);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
