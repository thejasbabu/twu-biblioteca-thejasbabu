package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvalidOptionTest {

    @Test
    public void shouldReturnInvalidOptionMessageWhenExecuted() {
        InvalidOption invalidOption = new InvalidOption();

        assertEquals("Invalid Option\n", invalidOption.execute());
    }
}