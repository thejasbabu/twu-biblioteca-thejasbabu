// Biblioteca class displays the welcome message and contains list of books
package com.thoughtworks.biblioteca;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private ArrayList<Book> books;
    private Display display;
    private Input input;
    private Parser parser;

    public Biblioteca(ArrayList<Book> books, Display display, Input input, Parser parser) {
        this.books = books;
        this.display = display;
        this.input = input;
        this.parser = parser;
    }

    public void start() {
        display.display("Welcome to Biblioteca\n");
        display.display("1. List Book\n 2.Quit\n");
        Options option = parser.parse(input.read());
        String displayMessage = option.execute();
        display.display(displayMessage);
    }
}
