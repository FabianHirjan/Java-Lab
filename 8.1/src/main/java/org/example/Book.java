package org.example;


public class Book {
    private int id;
    private int year;
    private String title;
    private Author author;
    private Genre genre;

    // Constructors
    public Book() {}

    public Book(int id, int year, String title, Author author, Genre genre) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
