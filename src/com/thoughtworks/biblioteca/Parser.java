// Parser parses the input which is given by th user to create the appropriate object
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Parser {

    private Display display;
    private Library library;

    public Parser(Display display, Library library) {
        this.display = display;
        this.library = library;
    }

    public Options parse(String option) {
        if(option.equals("1"))
            return new ListBook(display, library);
        else if(option.equals("2"))
            return new CheckOutOption();
        else if(option.equals("3"))
            return new ExitOption();
        else
            return new InvalidOption();
    }
}
