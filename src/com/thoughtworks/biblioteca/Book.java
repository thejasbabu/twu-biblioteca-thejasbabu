// Book class represents a book in biblioteca library
package com.thoughtworks.biblioteca;

public class Book {
    private String name;
    private String author;
    private String year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        String book = name + "\t\t" + author + "\t\t" + year + "\n";
        return book;
    }
}
