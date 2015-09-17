package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieListOptionTest {

    @Test
    public void shouldReturnListOfMoviesInTheLibrary() {
        Library library = mock(Library.class);
        MovieListOption movieListOption = new MovieListOption(library);
        when(library.movieList()).thenReturn("movieList called");

        assertEquals("movieList called", movieListOption.execute());
    }
}