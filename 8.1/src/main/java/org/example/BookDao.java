package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
    public void create(int year, String title, Integer author, Integer genre) throws SQLException {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("INSERT INTO books (year, title, author_id, genre_id) VALUES (?, ?, ?, ?)")) {
            statement.setInt(1, year);
            statement.setString(2, title);
            statement.setInt(3, author);
            statement.setInt(4, genre);
            statement.executeUpdate();
        }
    }

    public void showAll() {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM books")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int year = resultSet.getInt("year");
                String title = resultSet.getString("title");
                int authorId = resultSet.getInt("author_id");
                int genreId = resultSet.getInt("genre_id");

                System.out.println("ID: " + id + ", Year: " + year + ", Title: " + title + ", Author ID: " + authorId + ", Genre ID: " + genreId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
