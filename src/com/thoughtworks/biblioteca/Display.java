//Display class displays the message on the screen
package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Display {
    private PrintStream printStream;

    public Display(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void display(String message) {
        printStream.print(message);
    }
}