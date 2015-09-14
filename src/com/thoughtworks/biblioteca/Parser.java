// Parser parses the input which is given by th user to create the appropriate object
package com.thoughtworks.biblioteca;

public class Parser {

    private Display display;
    private Library library;
    private Input input;

    public Parser(Display display, Library library, Input input) {
        this.display = display;
        this.library = library;
        this.input = input;
    }

    public Options parse(String option) {
        if(option.equals("1"))
            return new ListBookOption(library);
        else if(option.equals("2"))
            return new CheckOutOption(display, input, library);
        else if(option.equals("3"))
            return new ReturnBookOption(display, input, library);
        else if(option.equals("4"))
            return new ExitOption();
        else
            return new InvalidOption();
    }
}
