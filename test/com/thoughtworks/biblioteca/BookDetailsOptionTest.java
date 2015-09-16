package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookDetailsOptionTest {

    @Test
    public void shouldCallTheBookDetailsMethodOfLibrary() {
        Library library = mock(Library.class);
        Session session = mock(Session.class);

        BookDetailsOption bookDetailsOption = new BookDetailsOption(session, library);
        bookDetailsOption.execute();

        verify(library).bookDetails();
    }
}