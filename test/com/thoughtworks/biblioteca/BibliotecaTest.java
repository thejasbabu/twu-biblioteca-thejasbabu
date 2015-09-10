package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void shouldReturnWelcomeMessageAndListOfBooksWhenBibliotecaApplicationHasStarted() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Inferno", "Dan Brown", "2001"));
        books.add(new Book("Harry Potter", "JK Rowling", "2005"));
        Biblioteca biblioteca = new Biblioteca(books);

        assertEquals("Welcome to Biblioteca\nNAME\t\tAUTHOR\t\tYEAR\nInferno\t\tDan Brown\t\t2001\nHarry Potter\t\tJK Rowling\t\t2005\n", biblioteca.display());
    }
}