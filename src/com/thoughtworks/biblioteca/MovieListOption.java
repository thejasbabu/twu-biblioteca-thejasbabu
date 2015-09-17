// MovieListOption returns the list of movies present in the library.
package com.thoughtworks.biblioteca;

public class MovieListOption implements Options{
    private Library library;

    public MovieListOption(Library library) {
        this.library = library;
    }

    @Override
    public String execute() {
        String movieList;
        movieList = library.movieList();
        return movieList;
    }
}
