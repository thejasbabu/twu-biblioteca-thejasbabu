package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void shouldReturnTheListOfBooksPresentInTheLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);

        assertEquals("NAME\t\tAUTHOR\t\tYEAR\nInferno\t\tDan Brown\t\t2001\n", library.toString());
    }

    @Test
    public void shouldReturnTrueWhenSuccesfulCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Gone girl", "Paulino", "2009"));
        Library library = new Library(books);

        assertEquals(true, library.checkOut("Gone girl"));
    }

    @Test
    public void shouldReturnFalseWhenCheckoutIsUnsuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Gone girl", "Paulino", "2009"));
        Library library = new Library(books);

        assertEquals(false, library.checkOut("Next"));
    }

    @Test
    public void shouldReturnTrueWhenCheckInIsSuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M.Crichton", "2009"));
        Library library = new Library(books);

        library.checkOut("Inferno");

        assertEquals(true, library.checkIn("Inferno"));
    }

    @Test
    public void shouldReturnFalseWhenCheckInIsNotSuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M.Crichton", "2009"));
        Library library = new Library(books);

        assertNotEquals(true, library.checkIn("Inferno"));
    }
}