package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckInOptionTest {

    @Test
    public void shouldReturnThankYouMessageWhenCheckoutISSuccessful() {
        Display display = new Display(new PrintStream(System.out));
        Input input = mock(Input.class);
        Library library = mock(Library.class);
        CheckInOption checkInOption = new CheckInOption(display, input, library);

        when(input.read()).thenReturn("Inferno");
        when(library.checkIn("Inferno")).thenReturn(true);

        assertEquals("Thank you for returning your book\n", checkInOption.execute());
    }

    @Test
    public void shouldReturnInvalidMessageWhenCheckInIsNotSuccessful () {
        Display display = new Display(new PrintStream(System.out));
        Input input = mock(Input.class);
        Library library = mock(Library.class);
        CheckInOption checkInOption = new CheckInOption(display, input, library);

        when(input.read()).thenReturn("Inferno");
        when(library.checkIn("Inferno")).thenReturn(false);

        assertEquals("This is not a valid book to return\n", checkInOption.execute());
    }
}