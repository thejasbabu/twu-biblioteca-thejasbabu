// ListBook class returns a string various book details to be printed on the screen
package com.thoughtworks.biblioteca;

public class ListBookOption implements Options{

    private Library library;

    public ListBookOption(Library library) {
        this.library = library;
    }

    @Override
    public String execute() {
        String listOfBooks;
        listOfBooks = library.bookList();
        return listOfBooks;
    }
}
