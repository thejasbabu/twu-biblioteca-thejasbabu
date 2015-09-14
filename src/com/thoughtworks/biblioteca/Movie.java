// Movie class represents a movie which is present in the library.
package com.thoughtworks.biblioteca;

public class Movie {
    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        String movieList;
        movieList = String.format("%-40s%-40s%-40s%-40s\n", name, year, director, rating);
        return movieList;
    }
}
