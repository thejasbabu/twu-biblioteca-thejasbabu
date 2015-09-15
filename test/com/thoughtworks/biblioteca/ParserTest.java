package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnAListBookObjectWhenOptionIsOne() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Parser parser = new Parser(display, library, input, userAccount);

        assertEquals(ListBookOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnAInvalidObjectWhenInvalidOptionIsEntered() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Parser parser = new Parser(display, library, input, userAccount);

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
        Parser parser = new Parser(display, library, input, userAccount);

        assertEquals(ExitOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnCheckOutOptionObjectWhenUserInputIsTwo() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Parser parser = new Parser(display, library, input, userAccount);

        assertEquals(CheckOutBookOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckInObjectWhenUserInputIsThree() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Parser parser = new Parser(display, library, input, userAccount);

        assertEquals(ReturnBookOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnMovieListWhenUserEntersFive() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Parser parser = new Parser(display, library, input, userAccount);

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
        Parser parser = new Parser(display, library, input, userAccount);

        assertEquals(CheckOutMovieOption.class, parser.parse("6").getClass());
    }
}