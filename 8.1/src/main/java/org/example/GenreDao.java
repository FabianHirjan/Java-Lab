package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDao {
    public Genre create(String name) throws SQLException {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("INSERT INTO genres (name) VALUES (?) RETURNING id, name")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Genre(resultSet.getInt("id"), resultSet.getString("name"));
            }
            return null;
        }
    }

    public Genre findByName(String name) throws SQLException {
        Genre genre = null;
        try (PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM genres WHERE name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                genre = new Genre(resultSet.getInt("id"), resultSet.getString("name"));
            }
        }
        return genre;
    }

    public void deleteall() throws SQLException {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("DELETE FROM genres")) {
            statement.executeUpdate();
            autoIncrementReset();
        }
    }

    private void autoIncrementReset() {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("ALTER SEQUENCE genres_id_seq RESTART WITH 1")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
