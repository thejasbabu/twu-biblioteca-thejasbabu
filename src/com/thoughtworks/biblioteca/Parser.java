// Parser parses the input which is given by th user to create the appropriate object
package com.thoughtworks.biblioteca;

public class Parser {

    private Display display;
    private Library library;
    private Input input;
    private UserAccount userAccount;
    private Session session;

    public Parser(Display display, Library library, Input input, UserAccount userAccount, Session session) {
        this.display = display;
        this.library = library;
        this.input = input;
        this.userAccount = userAccount;
        this.session = session;
    }

    public Options parse(String option) {
        if(option.equals("1"))
            return new ListBookOption(library);
        else if(option.equals("2") && ruleCheck())
            return new CheckOutBookOption(display, input, library, session);
        else if(option.equals("3") && ruleCheck())
            return new ReturnBookOption(display, input, library, session);
        else if(option.equals("4"))
            return new ExitOption();
        else if(option.equals("5"))
            return new MovieListOption(library, session);
        else if(option.equals("6"))
            return new CheckOutMovieOption(library, input, display, session);
        else if(option.equals("7"))
            return new LoginOption(userAccount, input, display, session);
        else if(option.equals("8") && ruleCheck())
            return new LogoutOption(session);
        else if(option.equals("9") && ruleCheck())
            return new BookDetailsOption(session, library);
        else
            return new InvalidOption();
    }

    private boolean ruleCheck() {
        return !session.getUser().getRole().equals(User.Role.INVALID);
    }
}
