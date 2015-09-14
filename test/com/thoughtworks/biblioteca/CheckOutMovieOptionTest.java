package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckOutMovieOptionTest {

    @Test
    public void shouldReturnThankyouMessageWhenCheckoutIsSuccessful() {
        Display display = new Display(new PrintStream(System.out));
        Input input = mock(Input.class);
        Library library = mock(Library.class);
        CheckOutMovieOption checkOutMovieOption = new CheckOutMovieOption(library, input, display);

        when(input.read()).thenReturn("Interstellar");
        when(library.checkOutMovie("Interstellar")).thenReturn(true);

        assertEquals("Thank you! Enjoy your movie\n", checkOutMovieOption.execute());
    }
}