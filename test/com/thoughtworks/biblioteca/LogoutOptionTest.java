package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LogoutOptionTest {

    @Test
    public void shouldReturnThankYouWhenExecuteIsCalled() {
        Session session = mock(Session.class);
        LogoutOption logoutOption = new LogoutOption(session);

        assertEquals("Thank You!", logoutOption.execute());
    }
}