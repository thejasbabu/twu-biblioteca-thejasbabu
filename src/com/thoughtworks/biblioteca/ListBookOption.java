// ListBook class returns a string various book details to be printed on the screen
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class ListBookOption implements Options{

    private Display display;
    private Library library;

    public ListBookOption(Display display, Library library) {
        this.display = display;
        this.library = library;
    }

    @Override
    public String execute() {
        String listOfBooks;
        listOfBooks = library.toString();
        return listOfBooks;
    }
}
