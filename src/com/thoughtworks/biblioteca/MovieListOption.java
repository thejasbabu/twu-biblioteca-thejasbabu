// MovieListOption returns the list of movies present in the library.
package com.thoughtworks.biblioteca;

public class MovieListOption implements Options{
    private Library library;
    private Session session;

    public MovieListOption(Library library, Session session) {
        this.library = library;
        this.session = session;
    }

    @Override
    public String execute() {
        String movieList;
        movieList = library.movieList();
        return movieList;
    }
}
