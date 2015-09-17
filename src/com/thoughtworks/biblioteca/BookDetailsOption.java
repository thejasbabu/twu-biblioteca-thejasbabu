// BookDetailsOption class calls the bookdetails method of library and returns book details
package com.thoughtworks.biblioteca;

public class BookDetailsOption implements Options{

    private Library library;

    public BookDetailsOption(Library library) {
        this.library = library;
    }

    @Override
    public String execute() {
        String bookDetails;
        bookDetails = library.bookDetails();
        return bookDetails;
    }
}
