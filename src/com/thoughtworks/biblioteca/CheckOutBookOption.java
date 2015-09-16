// CheckOutOption class calls the neccessary method of library class and return appropriate message back.
package com.thoughtworks.biblioteca;

public class CheckOutBookOption implements Options {

    private Display display;
    private Input input;
    private Library library;
    private Session session;

    public CheckOutBookOption(Display display, Input input, Library library, Session session) {
        this.display = display;
        this.input = input;
        this.library = library;
        this.session =  session;
    }

    @Override
    public String execute() {
        String enterNameMessage = "Enter the name of the book you want to checkout\n";
        display.display(enterNameMessage);
        String bookName = input.read();
        if (library.checkOutBook(bookName, session))
            return "Thank you! Enjoy your book\n";
        else
            return "This book is not available\n";
    }
}
