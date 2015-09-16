// ListBook class returns a string various book details to be printed on the screen
package com.thoughtworks.biblioteca;

public class ListBookOption implements Options{

    private Library library;
    private Session session;

    public ListBookOption(Library library, Session session) {
        this.library = library;
        this.session = session;
    }

    @Override
    public String execute() {
        String listOfBooks;
        listOfBooks = library.bookList();
        return listOfBooks;
    }
}
