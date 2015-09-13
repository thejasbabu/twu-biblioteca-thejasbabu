// CheckOutOption class calls the neccessary method of library class and return appropriate message back.
package com.thoughtworks.biblioteca;

public class CheckOutOption implements Options{

    private Display display;
    private Input input;
    private Library library;

    public CheckOutOption(Display display, Input input, Library library) {
        this.display = display;
        this.input = input;
        this.library = library;
    }

    @Override
    public String execute() {
        String enterNameMessage = "Enter the name of the book you want to checkout\n";
        display.display(enterNameMessage);
        String bookName = input.read();
        if (library.checkOut(bookName))
            return "Thank you! Enjoy your book\n";
        else
            return "This book is not available\n";
    }
}
