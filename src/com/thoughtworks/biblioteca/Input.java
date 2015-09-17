//Input class reads input and returns it.
package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        String input;
        input = scanner.nextLine();
        return input;
    }
}
