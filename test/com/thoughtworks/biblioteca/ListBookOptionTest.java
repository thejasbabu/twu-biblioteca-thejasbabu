package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListBookOptionTest {

    @Test
    public void shouldReturnListOfBooksWhenExecuteIsCalled() {
          Library library = mock(Library.class);
          when(library.bookList()).thenReturn("Booklist Called");
          ListBookOption listBookOption = new ListBookOption(library);
          assertEquals("Booklist Called", listBookOption.execute());
    }
}