// Application class starts the Biblioteca application.
package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args ) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        Display display = new Display(new PrintStream(System.out));
        Input input = new Input(new Scanner(System.in));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Interstellar", "Nolan", "2015", "9.2"));
        movies.add(new Movie("Matrix", "Andie", "2001", "8.9"));
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M. Crichton", "2005"));
        books.add(new Book("Harry Potter", "JK Rowling", "2004"));
        MenuFactory menuFactory = new MenuFactory();
        Library library = new Library(books, movies);
        User user = new User("XXX", "XXX", User.Role.INVALID, "", "", "");
        Session session = new Session(user);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-3333", "blah", User.Role.CUSTOMER, "Ozzy", "Ozzy@gmail.com", "0998999"));
        users.add(new User("123-3334", "blah1", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "0993399"));
        users.add(new User("123-3335", "blah2", User.Role.LIBRARIAN, "Django", "django@gmail.com", "5509989"));
        UserAccount userAccount = new UserAccount(users);
        Parser parser = new Parser(display, library, input, userAccount, session);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);
        biblioteca.start();
    }
}
