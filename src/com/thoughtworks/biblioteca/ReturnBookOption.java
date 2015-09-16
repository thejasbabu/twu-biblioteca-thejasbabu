// ReturnBookOption class calls the neccessary function of library class and returns whether the checkin was successful or not.
package com.thoughtworks.biblioteca;

public class ReturnBookOption implements Options{
    private Display display;
    private Input input;
    private Library library;
    private Session session;

    public ReturnBookOption(Display display, Input input, Library library, Session session) {
        this.display = display;
        this.input = input;
        this.library = library;
        this.session = session;
    }

    @Override
    public String execute() {
        String enterNameMessage = "Enter the name of the book you want to return\n";
        display.display(enterNameMessage);
        String bookName = input.read();
        if (library.returnBook(bookName, session))
            return "Thank you for returning your book\n";
        else
            return "This is not a valid book to return\n";
    }
}
