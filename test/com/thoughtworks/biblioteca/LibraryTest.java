package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LibraryTest {

    @Test
    public void shouldReturnTheListOfBooksPresentInTheLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books, movies);

        String header = String.format("%-40s%-40s%-40s\n","NAME", "AUTHOR", "YEAR");
        String bookList = String.format("%-40s%-40s%-40s\n","Inferno", "Dan Brown", "2001");
        assertEquals(header+bookList, library.bookList());
    }

    @Test
    public void shouldReturnTrueWhenSuccesfulCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Gone girl", "Paulino", "2009"));
        Library library = new Library(books, movies);
        Session session = mock(Session.class);

        assertEquals(true, library.checkOutBook("Gone girl", session));
    }

    @Test
    public void shouldReturnFalseWhenCheckoutIsUnsuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Gone girl", "Paulino", "2009"));
        Library library = new Library(books, movies);
        Session session = mock(Session.class);
        assertEquals(false, library.checkOutBook("Next", session));
    }

    @Test
    public void shouldReturnTrueWhenCheckInIsSuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M.Crichton", "2009"));
        Library library = new Library(books, movies);
        User user = new User("123-3333", "blah", User.Role.CUSTOMER);
        Session session = new Session(user);
        library.checkOutBook("Inferno", session);

        assertEquals(true, library.returnBook("Inferno", session));
    }

    @Test
    public void shouldReturnFalseWhenCheckInIsNotSuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M.Crichton", "2009"));
        Library library = new Library(books, movies);
        User user = new User("123-3333", "blah", User.Role.CUSTOMER);
        Session session = new Session(user);
        assertNotEquals(true, library.returnBook("Inferno", session));
    }

    @Test
    public void shouldReturnListOfMoviesInLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("The Good, The Bad and The Ugly", "Sergio Leone", "1966", "8.9"));
        Library library = new Library(books, movies);

        String header = String.format("%-40s%-40s%-40s%-40s\n", "NAME", "DIRECTOR", "YEAR", "RATING");
        String movieList = String.format("%-40s%-40s%-40s%-40s\n", "The Good, The Bad and The Ugly", "Sergio Leone", "1966", "8.9");

        assertEquals(header + movieList, library.movieList());
    }

    @Test
    public void shouldReturnTrueWhenMovieCheckOutIsSuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Interstellar", "Nolan", "2015", "9.2"));
        Library library = new Library(books, movies);

        assertEquals(true, library.checkOutMovie("Interstellar"));
    }

    @Test
    public void shouldReturnFalseWhenMovieCheckOutIsNotSuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Interstellar", "Nolan", "2015", "9.2"));
        Library library = new Library(books, movies);

        assertEquals(false, library.checkOutMovie("Next"));
    }
}