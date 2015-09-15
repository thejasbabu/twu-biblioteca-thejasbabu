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

    @Test
    public void shouldReturnFalseWhenPasswordAndUsernameIsNotSame() {
        User userOne = new User("LIB-1233", "Phew123");
        User userTwo = new User("LIB-1234", "Phew123");

        assertNotEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToNull() {
        User userOne = new User("LIB-1233", "Phew123");

        assertNotEquals(null, userOne);
    }
}