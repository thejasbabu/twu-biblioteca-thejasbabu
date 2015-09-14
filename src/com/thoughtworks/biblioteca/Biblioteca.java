// Biblioteca class displays the welcome message and contains list of books
package com.thoughtworks.biblioteca;

public class Biblioteca {

    private Display display;
    private Input input;
    private Parser parser;
    private Menu menu;

    public Biblioteca(Display display, Input input, Parser parser, Menu menu) {
        this.display = display;
        this.input = input;
        this.parser = parser;
        this.menu = menu;
    }

    public void start() {
        display.display("Welcome to Biblioteca\n");
        while(true) {
            run();
        }
    }

    void run() {
        display.display(menu.toString());
        Options option = parser.parse(input.read());
        String displayMessage = option.execute();
        display.display(displayMessage);
    }
}
