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

        assertEquals("NAME\t\tAUTHOR\t\tYEAR\nInferno\t\tDan Brown\t\t2001\n", listBookOption.execute());
    }
}