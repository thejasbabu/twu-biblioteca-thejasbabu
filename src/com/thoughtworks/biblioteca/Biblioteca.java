// Biblioteca class displays the welcome message and list of menu items
package com.thoughtworks.biblioteca;

public class Biblioteca {

    private Display display;
    private Input input;
    private Parser parser;
    private MenuFactory menuFactory;
    private Session session;


    public Biblioteca(Display display, Input input, Parser parser, MenuFactory menuFactory, Session session) {
        this.display = display;
        this.input = input;
        this.parser = parser;
        this.menuFactory = menuFactory;
        this.session = session;
    }

    public void start() {
        display.display("Welcome to Biblioteca\n");
        while(true) {
            run();
        }
    }

    void run() {
        User user = session.getUser();
        Menu menu = menuFactory.getMenu(user.getRole());
        display.display(menu.toString());
        Options option = parser.parse(input.read());
        String displayMessage = option.execute();
        display.display(displayMessage);
    }
}
