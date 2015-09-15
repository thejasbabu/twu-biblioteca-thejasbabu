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
        User user = new User("XXX", "XXX", User.Role.INVALID);
        LoginOption loginOption = new LoginOption(userAccount, input, display);
        when(input.read()).thenReturn("XXX", "meh");
        when(userAccount.authenticate("XXX", "meh")).thenReturn(user);

        assertEquals("LoginOption UnSuccesful\n", loginOption.execute(session));
    }

    @Test
    public void shouldReturnUnSuccessfulMessageWhenUserAuthenticationIsUnSuccessful() {
        UserAccount userAccount = mock(UserAccount.class);
        Input input = mock(Input.class);
        Display display = mock(Display.class);
        Session session = mock(Session.class);
        User user = new User("XXX", "XXX", User.Role.CUSTOMER);
        LoginOption loginOption = new LoginOption(userAccount, input, display);
        when(input.read()).thenReturn("XXX", "meh");
        when(userAccount.authenticate("XXX", "meh")).thenReturn(user);

        assertEquals("LoginOption Succesful\n", loginOption.execute(session));
    }
}