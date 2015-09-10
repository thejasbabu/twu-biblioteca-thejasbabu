package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void shouldReturnAListBookObjectWhenOptionIsOne() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        Parser parser = new Parser(display, books);

        assertEquals(ListBook.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnAInvalidObjectWhenInvalidOptionIsEntered() {
        Display display = new Display(new PrintStream(System.out));
        ArrayList<Book> books = new ArrayList<Book>();
        Parser parser = new Parser(display, books);

        assertEquals(InvalidOption.class, parser.parse("Biblioteca").getClass());
    }
}