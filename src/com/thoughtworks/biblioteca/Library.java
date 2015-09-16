// Library class contains list of books and movies and performs checkin,checkout tasks.
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> availableBooks;
    private HashMap<Book, User> checkedOutBooks;
    private ArrayList<Movie> availableMovies;

    public Library(ArrayList<Book> availableBooks, ArrayList<Movie> availableMovies) {
        this.availableBooks = availableBooks;
        this.availableMovies = availableMovies;
        checkedOutBooks = new HashMap<Book, User>();
    }

    public String bookList() {
        StringBuilder stringBuilder = new StringBuilder();
        String header = String.format("%-40s%-40s%-40s\n", "NAME", "AUTHOR", "YEAR");
        stringBuilder.append(header);
        for(Book book : availableBooks)
            stringBuilder.append(book.toString());
        return stringBuilder.toString();
    }

    public boolean checkOutBook(String bookName, Session session) {
        Book searchBook = new Book(bookName, "", "");
        for(Book book : availableBooks) {
            if(book.equals(searchBook))
            {
                availableBooks.remove(book);
                checkedOutBooks.put(book, session.getUser());
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName, Session session) {
        Book searchBook = new Book(bookName, "", "");
        for(Book book : checkedOutBooks.keySet()) {
            if(book.equals(searchBook) && session.getUser().equals(checkedOutBooks.get(book))){
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

    public boolean checkOutMovie(String movieName) {
        Movie searchMovie = new Movie(movieName, "", "", "");
        for(Movie movie : availableMovies) {
            if(movie.equals(searchMovie)) {
                availableMovies.remove(movie);
                return true;
            }
        }
        return false;
    }

    public String bookDetails() {
        StringBuilder bookDetails = new StringBuilder();
        String header = String.format("%-20s%-40s%-40s%-40s\n","LIB-NUMBER", "NAME", "AUTHOR", "YEAR");
        bookDetails.append(header);

        for(Book book : checkedOutBooks.keySet()) {
            String userNumber = checkedOutBooks.get(book).toString();
            String bookName = book.toString();
            String lineOfDetail = String.format("%-20s%-40s", userNumber, bookName);
            bookDetails.append(lineOfDetail);
        }

        return bookDetails.toString();
    }
}
