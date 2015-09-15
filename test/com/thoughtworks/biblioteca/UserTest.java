package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldReturnTrueWhenPasswordAndUsernameIsSame() {
        User userOne = new User("LIB-1234", "Phew123");
        User userTwo = new User("LIB-1234", "Phew123");

        assertEquals(userOne, userTwo);
    }
}