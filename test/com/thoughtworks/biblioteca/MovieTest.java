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
}