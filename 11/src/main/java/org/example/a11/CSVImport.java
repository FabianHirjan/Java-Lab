package org.example.a11;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVImport {
    public static void importDataFromCSV(String filePath) throws IOException, SQLException {
        try (FileReader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                String title = record.get("title");
                String authorName = record.get("authors");
                String languageCode = record.get("language_code");

                insertData(title, authorName, languageCode);
            }
        }
    }

    private static void insertData(String title, String authorName, String languageCode) throws SQLException {
        // Implement logic to insert title, author, and genre into respective tables
        // You can call the appropriate DAO methods from here
        AuthorDao authorDao = new AuthorDao();
        GenreDao genreDao = new GenreDao();
        BookDao bookDao = new BookDao();

        Author author = new Author();
        author.setName(authorName);
        author = authorDao.create(author.getName()); // Update the author object with the created author

        Genre genre = genreDao.findByName(languageCode);
        if (genre == null) {
            genre = new Genre();
            genre.setName(languageCode);
            genre = genreDao.create(genre.getName());
        }

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        bookDao.create(book);
    }
}
