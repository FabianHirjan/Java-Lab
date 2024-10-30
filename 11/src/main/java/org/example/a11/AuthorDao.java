package org.example.a11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDao {
    public Author create(String name) throws SQLException {
        String sql = "INSERT INTO authors (name) VALUES (?) RETURNING id, name;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Author(resultSet.getInt("id"), resultSet.getString("name"));
            }
            return null; // or throw an exception if you prefer
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

    public Author findByName(String name) throws SQLException {
        Author author = null;
        try (PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM authors WHERE name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                author = new Author(resultSet.getInt("id"), resultSet.getString("name"));
            }
        }
        return author;
    }
}
