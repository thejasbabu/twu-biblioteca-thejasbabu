package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void shouldReturnWelcomeMessageWhenBibliotecaApplicationHasStarted() {
        Biblioteca biblioteca = new Biblioteca();

        assertEquals("Welcome to Biblioteca\n", biblioteca.WelcomeMessage());
    }
}