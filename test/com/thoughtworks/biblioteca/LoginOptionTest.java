package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginOptionTest {

    @Test
    public void shouldReturnSuccessfulMessageWhenUserAuthenticationIsSuccessful() {
        UserAccount userAccount = mock(UserAccount.class);
        Input input = mock(Input.class);
        Display display = mock(Display.class);
        Session session = mock(Session.class);
        User user = new User("XXX", "XXX", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899");
        LoginOption loginOption = new LoginOption(userAccount, input, display, session);
        when(input.read()).thenReturn("XXX", "meh");
        when(userAccount.authenticate("XXX", "meh")).thenReturn(user);

        assertEquals("Login UnSuccesful\n", loginOption.execute());
    }

    @Test
    public void shouldReturnUnSuccessfulMessageWhenUserAuthenticationIsUnSuccessful() {
        UserAccount userAccount = mock(UserAccount.class);
        Input input = mock(Input.class);
        Display display = mock(Display.class);
        Session session = mock(Session.class);
        User user = new User("XXX", "XXX", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899");
        LoginOption loginOption = new LoginOption(userAccount, input, display, session);
        when(input.read()).thenReturn("XXX", "meh");
        when(userAccount.authenticate("XXX", "meh")).thenReturn(user);

        assertEquals("Login Succesful\n", loginOption.execute());
    }
}