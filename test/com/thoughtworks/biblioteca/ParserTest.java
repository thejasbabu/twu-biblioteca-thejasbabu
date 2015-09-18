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
        Session session = new Session(new User("123-3333", "blah", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
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
        Session session = new Session(new User("123-3333", "blah", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(ExitOption.class, parser.parse("0").getClass());
    }

    @Test
    public void shouldReturnMovieListWhenUserSelectsMovieListOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(MovieListOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieOptionObjectWhenUserSelectsMovieCheckoutOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(CheckOutMovieOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnInvalidOptionObjectWhenCheckoutBookOptionIsCalledWithoutLogin() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(InvalidOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnInvalidOptionObjectWhenCheckInBookOptionIsCalledWithoutLogin() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(InvalidOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnLogoutOptionObjectWhenUserEntersLogoutOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(LogoutOption.class, parser.parse("9").getClass());
    }

    @Test
    public void shouldReturnBookDetailsOptionWhenLibrarianSelectsBookDetailsOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.LIBRARIAN, "Osbourne", "Os@gmail.com", "099899"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(BookDetailsOption.class, parser.parse("7").getClass());
    }

    @Test
    public void shouldReturnInvalidOptionWhenOtherUserSelectsBookDetailsOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(InvalidOption.class, parser.parse("7").getClass());
    }

    @Test
    public void shouldReturnBookListOptionWhenUserSelectsBookListOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(ListBookOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnUserDetailsObjectWhenUserSelectsUserDetailsOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.CUSTOMER, "Ozzy", "Ozzy@Gmail.com", "99980"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(UserDetailsOption.class, parser.parse("6").getClass());
    }

    @Test
    public void shouldReturnLoginOptionObjectWhenUserSelectsLoginOption() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(books, movies);
        Input input = new Input(new Scanner(System.in));
        UserAccount userAccount = mock(UserAccount.class);
        Session session = new Session(new User("123-3333", "blah", User.Role.INVALID, "Ozzy", "Ozzy@Gmail.com", "99980"));
        Parser parser = new Parser(display, library, input, userAccount, session);

        assertEquals(LoginOption.class, parser.parse("8").getClass());
    }
}