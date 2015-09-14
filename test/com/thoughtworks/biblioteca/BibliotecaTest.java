package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mockito.Mockito.*;


public class BibliotecaTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();


    @Test
    public void shouldReturnWelcomeMessageWhenBibliotecaApplicationHasStarted() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Harry Potter", "JK Rowling", "2005"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ExitOption exitOption = mock(ExitOption.class);
        //Parser parser = new Parser(display, library, input);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("4");
        when(parser.parse("4")).thenReturn(exitOption);
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
        Parser parser = mock(Parser.class);
        ExitOption exitOption = mock(ExitOption.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("1", "4");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute()).thenReturn("listBookOption Called");
        when(parser.parse("4")).thenReturn(exitOption);

        exit.expectSystemExitWithStatus(0);
        biblioteca.start();

        verify(display).display("listBookOption Called");
    }

    @Test
    public void shouldDisplayListOfBooksWhenUserEntersOptionOne() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        biblioteca.start();

        verify(listBookOption).execute();
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
        when(input.read()).thenReturn("4");
        when(parser.parse("4")).thenReturn(exitOption);
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

    @Test
    public void shouldExecuteCheckInOptionWhenUserEntersThreeAsTheirChoice() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        Library library = new Library(books);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        CheckInOption checkInOption = mock(CheckInOption.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        when(input.read()).thenReturn("3");
        when(parser.parse("3")).thenReturn(checkInOption);
        biblioteca.start();

        verify(checkInOption).execute();
    }
}