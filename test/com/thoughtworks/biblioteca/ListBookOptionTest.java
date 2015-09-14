package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListBookOptionTest {

    @Test
    public void shouldReturnListOfBooksWhenExecuteIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books, movies);
        ListBookOption listBookOption = new ListBookOption(library);

        String header = String.format("%-40s%-40s%-40s\n", "NAME", "AUTHOR", "YEAR");
        String bookList = String.format("%-40s%-40s%-40s\n", "Inferno", "Dan Brown", "2001");
        assertEquals(header + bookList, listBookOption.execute());
    }
}