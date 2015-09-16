package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void shouldRetrunTheUserObjectWhenGetUserIsCalled() {
        User user = new User("123-1234", "Bleh", User.Role.CUSTOMER);
        Session session = new Session(user);

        assertEquals(user, session.getUser());
    }
}