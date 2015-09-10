package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnABookObjectInColumnFashion() {
        Book book = new Book("Inferno", "Dan Brown", "2001");

        assertEquals("Inferno\t\tDan Brown\t\t2001\n", book.toString());
    }

    @Test
    public void shouldNotBeEqualToNull() {
        Book book = new Book("Inferno", "Dan Brown", "2001");

        assertNotEquals(book, null);
    }

    @Test
    public void shouldBeEqualsToAnotherBookWithSameName() {
        Book bookOne = new Book("Inferno", "Dan Brown", "2001");
        Book bookTwo = new Book("Inferno", "Dan Crown", "2008");

        assertEquals(bookOne, bookTwo);
    }
}