package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Database.createConnection();

            var authors = new AuthorDao();
            authors.create("Susanu");

            var genres = new GenreDao();
            //genres.create("Nebunia lui Susanu");

            //authors.findByName("Susanu");
            var books = new BookDao();
            //books.create(2021, "Sistem Turbat", 14, 1);


            Database.commit();
            books.showAll();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
