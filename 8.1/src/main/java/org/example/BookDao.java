package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
    public void create(Book book) throws SQLException {
        try (PreparedStatement statement = Database.getConnection().prepareStatement("INSERT INTO books (year, title, author_id, genre_id) VALUES (?, ?, ?, ?)")) {
            statement.setInt(1, book.getYear());
            statement.setString(2, book.getTitle());
            statement.setInt(3, book.getAuthor().getId());
            statement.setInt(4, book.getGenre().getId());
            statement.executeUpdate();
            System.out.println("Book + " + book.getTitle() + " added to the database");
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
