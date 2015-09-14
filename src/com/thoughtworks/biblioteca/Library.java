// Library class contains list of books and movies and performs checkin,checkout tasks.
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Movie> availableMovies;

    public Library(ArrayList<Book> availableBooks, ArrayList<Movie> availableMovies) {
        this.availableBooks = availableBooks;
        this.availableMovies = availableMovies;
        checkedOutBooks = new ArrayList<Book>();
    }

    public String bookList() {
        StringBuilder stringBuilder = new StringBuilder();
        String header = String.format("%-40s%-40s%-40s\n", "NAME", "AUTHOR", "YEAR");
        stringBuilder.append(header);
        for(Book book : availableBooks)
            stringBuilder.append(book.toString());
        return stringBuilder.toString();
    }

    public boolean checkOut(String bookName) {
        Book searchBook = new Book(bookName, "", "");
        for(Book book : availableBooks) {
            if(book.equals(searchBook))
            {
                availableBooks.remove(book);
                checkedOutBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean checkIn(String bookName) {
        Book searchBook = new Book(bookName, "", "");
        for(Book book : checkedOutBooks) {
            if(book.equals(searchBook)){
                checkedOutBooks.remove(book);
                availableBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public String movieList() {
        StringBuilder stringBuilder = new StringBuilder();
        String header = String.format("%-40s%-40s%-40s%-40s\n", "NAME", "DIRECTOR", "YEAR", "RATING");
        stringBuilder.append(header);
        for(Movie movie : availableMovies) {
            stringBuilder.append(movie.toString());
        }
        return stringBuilder.toString();
    }
}
