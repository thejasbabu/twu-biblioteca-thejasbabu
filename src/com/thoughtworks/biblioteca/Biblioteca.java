// Biblioteca class displays the welcome message and contains list of books
package com.thoughtworks.biblioteca;

public class Biblioteca {

    private Display display;
    private Input input;
    private Parser parser;

    public Biblioteca(Display display, Input input, Parser parser) {
        this.display = display;
        this.input = input;
        this.parser = parser;
    }

    public void start() {
        display.display("Welcome to Biblioteca\n");
       while(true) {
            display.display("1. List Book\n2. Checkout Book\n3. Checkin Book\n4. Exit\n");
            Options option = parser.parse(input.read());
            String displayMessage = option.execute();
            display.display(displayMessage);
        }
    }
}
