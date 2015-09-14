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
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Next", "M. Crichton", "2005"));
        books.add(new Book("Harry Potter", "JK Rowling", "2004"));
        Library library = new Library(books);
        Parser parser = new Parser(display, library, input);
        Biblioteca biblioteca = new Biblioteca(display, input, parser);
        biblioteca.start();
    }
}
