package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void shouldReturnWelcomeMessageAndListOfBooksWhenBibliotecaApplicationHasStarted() {
        ArrayList<String> books = new ArrayList<String>();
        books.add("Inferno");
        books.add("Harry Potter");
        Biblioteca biblioteca = new Biblioteca(books);

        assertEquals("Welcome to Biblioteca\nInferno\nHarry Potter\n", biblioteca.display());
    }
}