// Parser parses the input which is given by th user to create the appropriate object
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
        else if(option.equals("2"))
            return new ExitOption();
        else
            return new InvalidOption();
    }
}
