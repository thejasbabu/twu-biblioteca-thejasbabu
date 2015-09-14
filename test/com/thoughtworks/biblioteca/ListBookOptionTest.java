package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListBookOptionTest {

    @Test
    public void shouldReturnListOfBooksWhenExecuteIsCalled() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);
        ListBookOption listBookOption = new ListBookOption(display, library);

        String header = String.format("%-40s%-40s%-40s\n", "NAME", "AUTHOR", "YEAR");
        String bookList = String.format("%-40s%-40s%-40s\n", "Inferno", "Dan Brown", "2001");
        assertEquals(header + bookList, listBookOption.execute());
    }
}