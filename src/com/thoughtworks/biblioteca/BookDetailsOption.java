package com.thoughtworks.biblioteca;

public class BookDetailsOption implements Options{

    private Session session;
    private Library library;

    public BookDetailsOption(Session session, Library library) {
        this.session = session;
        this.library = library;
    }

    @Override
    public String execute() {
        String bookDetails;
        bookDetails = library.bookDetails();
        return bookDetails;
    }
}
