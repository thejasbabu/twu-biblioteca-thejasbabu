package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTest {

    @Test
    public void shouldReturnSuccessfulMessageWhenUserAuthenticationIsSuccessful() {
        UserAccount userAccount = mock(UserAccount.class);
        Input input = mock(Input.class);
        Display display = mock(Display.class);
        Session session = mock(Session.class);
        User user = new User("XXX", "XXX", User.Role.INVALID);
        Login login = new Login(userAccount, input, display);
        when(input.read()).thenReturn("XXX", "meh");
        when(userAccount.authenticate("XXX", "meh")).thenReturn(user);

        assertEquals("Login UnSuccesful\n", login.execute(session));
    }

    @Test
    public void shouldReturnUnSuccessfulMessageWhenUserAuthenticationIsUnSuccessful() {
        UserAccount userAccount = mock(UserAccount.class);
        Input input = mock(Input.class);
        Display display = mock(Display.class);
        Session session = mock(Session.class);
        User user = new User("XXX", "XXX", User.Role.CUSTOMER);
        Login login = new Login(userAccount, input, display);
        when(input.read()).thenReturn("XXX", "meh");
        when(userAccount.authenticate("XXX", "meh")).thenReturn(user);

        assertEquals("Login Succesful\n", login.execute(session));
    }
}