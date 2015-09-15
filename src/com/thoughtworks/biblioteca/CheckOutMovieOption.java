//CheckOutMovieOption class performs the checkout movie method and returns appropriate message
package com.thoughtworks.biblioteca;


public class CheckOutMovieOption implements Options{

    private Library library;
    private Input input;
    private Display display;

    public CheckOutMovieOption(Library library, Input input, Display display) {
        this.library = library;
        this.input = input;
        this.display = display;
    }

    @Override
    public String execute(Session session) {
        String enterNameMessage = "Enter the name of the movie you want to checkout\n";
        display.display(enterNameMessage);
        String movieName = input.read();
        if (library.checkOutMovie(movieName))
            return "Thank you! Enjoy your movie\n";
        else
            return "This movie is not available\n";
    }
}
