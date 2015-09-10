package com.thoughtworks.biblioteca;


import java.util.ArrayList;

public class Parser {

    private Display display;
    private ArrayList<Book> books;

    public Parser(Display display, ArrayList<Book> books) {
        this.display = display;
        this.books = books;
    }

    public Options parse(String option) {
        if(option.equals("1"))
            return new ListBook(display, books);
        else
            return new InvalidOption();
    }
}
