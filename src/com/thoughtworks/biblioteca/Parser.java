// Parser parses the input which is given by th user to create the appropriate object
package com.thoughtworks.biblioteca;

public class Parser {

    private Display display;
    private Library library;
    private Input input;
    private UserAccount userAccount;

    public Parser(Display display, Library library, Input input, UserAccount userAccount) {
        this.display = display;
        this.library = library;
        this.input = input;
        this.userAccount = userAccount;
    }

    public Options parse(String option) {
        if(option.equals("1"))
            return new ListBookOption(library);
        else if(option.equals("2"))
            return new CheckOutBookOption(display, input, library);
        else if(option.equals("3"))
            return new ReturnBookOption(display, input, library);
        else if(option.equals("4"))
            return new ExitOption();
        else if(option.equals("5"))
            return new MovieListOption(library);
        else if(option.equals("6"))
            return new CheckOutMovieOption(library, input, display);
        else if(option.equals("7"))
            return new LoginOption(userAccount, input, display);
        else
            return new InvalidOption();
    }
}
