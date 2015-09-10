// Biblioteca class displays the welcome message and contains list of books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private ArrayList<Book> books;
    private Display display;
    private Input input;

    public Biblioteca(ArrayList<Book> books, Display display, Input input) {
        this.books = books;
        this.display = display;
        this.input = input;
    }

    public void start() {
        StringBuilder stringBuilder = new StringBuilder();
        display.display("Welcome to Biblioteca\n");
        display.display("1. List Book\n");
        String option = input.read();
        if(option.equals("1")) {
            stringBuilder.append("NAME\t\tAUTHOR\t\tYEAR\n");
            for(Book book : books)
                stringBuilder.append(book.toString());
            display.display(stringBuilder.toString());
        }
        else
            display.display("");
    }
}
