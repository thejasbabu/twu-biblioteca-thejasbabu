package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckOutBookOptionTest {

    @Test
    public void shouldReturnThankYouMessageWhenCheckoutISSuccessful() {
        Display display = new Display(new PrintStream(System.out));
        Input input = mock(Input.class);
        Library library = mock(Library.class);
        Session session = mock(Session.class);
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption(display, input, library, session);

        when(input.read()).thenReturn("Inferno");
        when(library.checkOutBook("Inferno")).thenReturn(true);

        assertEquals("Thank you! Enjoy your book\n", checkOutBookOption.execute());
    }

    @Test
    public void shouldReturnInvalidMeesageWhenCheckoutIsNotSuccessful() {
        Display display = new Display(new PrintStream(System.out));
        Input input = mock(Input.class);
        Library library = mock(Library.class);
        Session session = mock(Session.class);
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption(display, input, library, session);

        when(input.read()).thenReturn("Next");
        when(library.checkOutBook("Next")).thenReturn(false);

        assertEquals("This book is not available\n", checkOutBookOption.execute());
    }
}