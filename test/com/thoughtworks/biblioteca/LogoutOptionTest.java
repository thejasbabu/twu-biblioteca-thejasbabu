package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LogoutOptionTest {

    @Test
    public void shouldReturnThankYouWhenExecuteIsCalled() {
        Session session = mock(Session.class);
        LogoutOption logoutOption = new LogoutOption(session);

        assertEquals("Thank You!\n", logoutOption.execute());
    }

    @Test
    public void shouldSetTheUserToInvalidUserWhenLogoutSuccessfulIsCalled() {
        User user = new User("XXX", "XXX", User.Role.INVALID);
        Session session = mock(Session.class);
        LogoutOption logoutOption = new LogoutOption(session);

        assertEquals(user.getRole(), logoutOption.getNewUser().getRole());
    }
}