package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnAInvalidObjectWhenInvalidOptionIsEntered() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.CUSTOMER));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(InvalidOption.class, parser.parse("Biblioteca").getClass());
    }

    @Test
    public void shouldReturnExitOptionObjectWhenExitOptionIsSelected() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.CUSTOMER));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(ExitOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnMovieListWhenUserEntersFive() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(MovieListOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieOptionObjectWhenUserEntersSix() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(CheckOutMovieOption.class, parser.parse("6").getClass());
    }

    @Test
    public void shouldReturnInvalidOptionObjectWhenCheckoutOptionIsCalledWithoutLogin() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.INVALID));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(InvalidOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnInvalidOptionObjectWhenCheckInOptionIsCalledWithoutLogin() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.INVALID));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(InvalidOption.class, parser.parse("3").getClass());
    }
}