package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BibliotecaTest {
    String userChoice = "1";
    final ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());

    @Before
    public void setUp() {
        System.setIn(inContent);
    }
    @Test
    public void shouldReturnWelcomeMessageAndListOfBooksWhenBibliotecaApplicationHasStarted() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Harry Potter", "JK Rowling", "2005"));
        Display display = mock(Display.class);
        Biblioteca biblioteca = new Biblioteca(books, display);

        biblioteca.start();

        verify(display).display("Welcome to Biblioteca\n");
    }
}