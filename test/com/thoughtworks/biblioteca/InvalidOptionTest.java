package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class InvalidOptionTest {

    @Test
    public void shouldReturnInvalidOptionMessageWhenExecuted() {
        InvalidOption invalidOption = new InvalidOption();
        Session session = mock(Session.class);
        assertEquals("Invalid Option\n", invalidOption.execute(session));
    }
}