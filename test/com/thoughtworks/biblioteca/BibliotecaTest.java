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
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = new Input(new Scanner(System.in));
        Parser parser = new Parser(display, library, input);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);

        biblioteca.start();

        verify(display).display("Welcome to Biblioteca\n");
    }

    @Test
    public void shouldDisplayMenuOptionsAlongWithWelcomeMessage() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Harry Potter", "JK Rowling", "2005"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = new Parser(display, library, input);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("1");
        biblioteca.start();

        verify(display).display("1. List Book\n 2. Checkout Book\n 3.Quit\n");
    }

    @Test
    public void shouldDisplayListOfBooksWhenUserEntersOptionOne() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBook listBook = mock(ListBook.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBook);
        biblioteca.start();

        verify(listBook).execute();
    }

    @Test
    public void shouldDisplayInvalidOptionWhenUserEntersInvalidChoice() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        InvalidOption invalidOption = mock(InvalidOption.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("Biblioteca");
        when(parser.parse("Biblioteca")).thenReturn(invalidOption);
        biblioteca.start();

        verify(invalidOption).execute();
    }

    @Test
    public void shouldExitFromTheApplicationWhenExitOptionIsSelected() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ExitOption exitOption = mock(ExitOption.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("3");
        when(parser.parse("3")).thenReturn(exitOption);
        biblioteca.start();

        verify(exitOption).execute();
    }

    @Test
    public void shouldExecuteCheckOutOptionWhenUserEntersTwoAsTheirChoice() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        CheckOutOption checkOutOption = mock(CheckOutOption.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("2");
        when(parser.parse("2")).thenReturn(checkOutOption);
        biblioteca.start();

        verify(checkOutOption).execute();
    }
    @After
    public void cleanUp() {
        System.setIn(System.in);
    }
}