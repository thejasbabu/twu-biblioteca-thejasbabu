// Biblioteca class displays the welcome message and contains list of books
package com.thoughtworks.biblioteca;

public class Biblioteca {

    private Display display;
    private Input input;
    private Parser parser;
    private Menu menu;
    private Session session;


    public Biblioteca(Display display, Input input, Parser parser, Menu menu, Session session) {
        this.display = display;
        this.input = input;
        this.parser = parser;
        this.menu = menu;
        this.session = session;
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
        String displayMessage = option.execute(session);
        display.display(displayMessage);
    }
}
