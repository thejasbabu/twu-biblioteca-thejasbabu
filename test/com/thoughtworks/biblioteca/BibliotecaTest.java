package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mockito.Mockito.*;


public class BibliotecaTest {
    String userChoice = "1";
    final ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());

    @Before
    public void setUp() {
        System.setIn(inContent);
    }

    @Test
    public void shouldReturnWelcomeMessageWhenBibliotecaApplicationHasStarted() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Harry Potter", "JK Rowling", "2005"));
        Display display = mock(Display.class);
        Input input = new Input(new Scanner(System.in));
        Biblioteca biblioteca = new Biblioteca(books, display, input);

        biblioteca.start();

        verify(display).display("Welcome to Biblioteca\n");
    }

    @Test
    public void shouldDisplayMenuOptionsAlongWithWelcomeMessage() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Harry Potter", "JK Rowling", "2005"));
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Biblioteca biblioteca = new Biblioteca(books, display, input);
        when(input.read()).thenReturn("1");
        biblioteca.start();

        verify(display).display("1. List Book\n");
    }

    @Test
    public void shouldDisplayListOfBooksWhenUserEntersOptionOne() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Biblioteca biblioteca = new Biblioteca(books, display, input);
        when(input.read()).thenReturn("1");
        biblioteca.start();

        verify(display).display("NAME\t\tAUTHOR\t\tYEAR\nInferno\t\tDan Brown\t\t2001\n");
    }

    @After
    public void cleanUp() {
        System.setIn(System.in);
    }
}