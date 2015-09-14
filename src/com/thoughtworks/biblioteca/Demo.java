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
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M. Crichton", "2005"));
        books.add(new Book("Harry Potter", "JK Rowling", "2004"));
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("1. List Book");
        menuItems.add("2. Checkout Book");
        menuItems.add("3. Checkin Book");
        menuItems.add("4. Exit");
        menuItems.add("5. List Movie");

        Menu menu = new Menu(menuItems);
        Library library = new Library(books, movies);
        Parser parser = new Parser(display, library, input);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu);
        biblioteca.start();
    }
}
