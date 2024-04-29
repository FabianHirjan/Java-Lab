package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            CSVImport.importDataFromCSV("/Users/fabian-andreihirjan/Desktop/Java-Github/Java/8.1/src/main/java/org/example/books.csv");

           // Database.commit();
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
            Database.rollback();
        } finally {
            Database.closeDataSource();
        }
    }
}
