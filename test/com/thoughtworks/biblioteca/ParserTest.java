package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void shouldReturnAListBookObjectWhenOptionIsOne() {
        Parser parser = new Parser();

        assertEquals(ListBook.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnAInvalidObjectWhenInvalidOptionIsEntered() {
        Parser parser = new Parser();

        assertEquals(InvalidOption.class, parser.parse("Biblioteca").getClass());
    }
}