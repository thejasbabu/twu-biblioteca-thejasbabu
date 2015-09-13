package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckOutOptionTest {

    @Test
    public void shouldReturnThankYouMessageWhenCheckoutISSuccessful() {
        Display display = new Display(new PrintStream(System.out));
        Input input = mock(Input.class);
        Library library = mock(Library.class);
        CheckOutOption checkOutOption = new CheckOutOption(display, input, library);

        when(input.read()).thenReturn("Inferno");
        when(library.checkOut("Inferno")).thenReturn(true);

        assertEquals("Thank you! Enjoy your book\n", checkOutOption.execute());
    }

    @Test
    public void shouldReturnInvalidMeesageWhenCheckoutIsNotSuccessful() {
        Display display = new Display(new PrintStream(System.out));
        Input input = mock(Input.class);
        Library library = mock(Library.class);
        CheckOutOption checkOutOption = new CheckOutOption(display, input, library);

        when(input.read()).thenReturn("Next");
        when(library.checkOut("Next")).thenReturn(false);

        assertEquals("This book is not available\n", checkOutOption.execute());
    }
}