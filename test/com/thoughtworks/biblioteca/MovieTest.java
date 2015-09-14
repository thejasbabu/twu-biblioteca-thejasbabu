package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldReturnBookInColumnarFashion() {
        Movie movie = new Movie("The Good,The Bad and The Ugly", "1966", "Sergio Leone", "8.9");

        String movieList = String.format("%-40s%-40s%-40s%-40s\n","The Good,The Bad and The Ugly", "1966", "Sergio Leone", "8.9");
        assertEquals(movieList, movie.toString());
    }

    @Test
    public void shouldReturnTrueWhenMoviesHaveSameName() {
        Movie movieOne = new Movie("Interstellar", "Nolan", "2015", "9.3");
        Movie movieTwo = new Movie("Interstellar", "C.Nolan", "2014", "9.3");

        assertEquals(movieOne, movieTwo);
    }
}