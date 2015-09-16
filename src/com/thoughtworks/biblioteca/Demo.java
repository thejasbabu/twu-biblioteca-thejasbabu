// Demo class starts the Biblioteca application.
package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args ) {
        Display display = new Display(new PrintStream(System.out));
        Input input = new Input(new Scanner(System.in));
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("The Good, The Bad and The Ugly", "Sergio Leone", "1966", "8.9"));
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M. Crichton", "2005"));
        books.add(new Book("Harry Potter", "JK Rowling", "2004"));
        ArrayList<String> defaultItems = new ArrayList<String>();
        defaultItems.add("1. List Book");
        defaultItems.add("4. Exit");
        defaultItems.add("5. List Movie");
        defaultItems.add("6. Checkout Movie");
        defaultItems.add("7. Login");
        ArrayList<String> customerItems = new ArrayList<String>();
        customerItems.add("1. List Book");
        customerItems.add("2. Checkout Book");
        customerItems.add("3. Return Book");
        customerItems.add("4. Exit");
        customerItems.add("5. List Movie");
        customerItems.add("6. Checkout Movie");
        customerItems.add("8. Logout");
        ArrayList<String> librarianItems = new ArrayList<String>();
        librarianItems.add("1. List Book");
        librarianItems.add("2. Checkout Book");
        librarianItems.add("3. Return Book");
        librarianItems.add("4. Exit");
        librarianItems.add("5. List Movie");
        librarianItems.add("6. Checkout Movie");
        librarianItems.add("8. Logout");
        librarianItems.add("9. User details");

        Menu menu = new Menu(defaultItems, customerItems, librarianItems);
        Library library = new Library(books, movies);
        User user = new User("XXX", "XXX", User.Role.INVALID);
        Session session = new Session(user);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-3333", "blah", User.Role.CUSTOMER));
        users.add(new User("123-3334", "blah1", User.Role.CUSTOMER));
        users.add(new User("123-3335", "blah2", User.Role.LIBRARIAN));
        UserAccount userAccount = new UserAccount(users);
        Parser parser = new Parser(display, library, input, userAccount, session);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        biblioteca.start();
    }
}
