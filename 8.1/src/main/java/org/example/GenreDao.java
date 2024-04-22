package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenreDao {
    public void create(String name) throws SQLException {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("INSERT INTO genres (name) VALUES (?)")) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
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
