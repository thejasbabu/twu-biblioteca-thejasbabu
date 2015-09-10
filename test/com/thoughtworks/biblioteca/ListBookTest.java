package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListBookTest {

    @Test
    public void shouldReturnListOfBooksWhenExecuteIsCalled() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        ListBook listBook = new ListBook(display, books);

        assertEquals("NAME\t\tAUTHOR\t\tYEAR\nInferno\t\tDan Brown\t\t2001\n", listBook.execute());
    }
}