package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldReturnBookInColumnarFashion() {
        Movie movie = new Movie("Interstellar", "1966", "Sergio Leone", "8.9");

        String movieList = String.format("%-20s%-20s%-20s%-20s\n","Interstellar", "1966", "Sergio Leone", "8.9");
        assertEquals(movieList, movie.toString());
    }

    @Test
    public void shouldReturnTrueWhenMoviesHaveSameName() {
        Movie movieOne = new Movie("Interstellar", "Nolan", "2015", "9.3");
        Movie movieTwo = new Movie("Interstellar", "C.Nolan", "2014", "9.3");

        assertEquals(movieOne, movieTwo);
    }

    @Test
    public void shouldNotBeEqualToNull() {
        Movie movie = new Movie("Interstellar", "Nolan", "2015", "9.3");

        assertNotEquals(null, movie);
    }
}