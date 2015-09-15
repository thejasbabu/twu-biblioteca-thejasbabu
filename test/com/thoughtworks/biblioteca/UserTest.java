package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldReturnTrueWhenUsernameIsSame() {
        User userOne = new User("LIB-1234", "Phew123");
        User userTwo = new User("LIB-1234", "Phew123");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldReturnFalseWhenUsernameIsNotSame() {
        User userOne = new User("LIB-1233", "Phew123");
        User userTwo = new User("LIB-1234", "Phew123");

        assertNotEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToNull() {
        User userOne = new User("LIB-1233", "Phew123");

        assertNotEquals(null, userOne);
    }

    @Test
    public void shouldReturnTrueWhenPasswordOfTwoUserIsSame() {
        User userOne = new User("LIB-1233", "Phew123");
        User userTwo = new User("LIB-1133", "Phew123");

        assertEquals(true, userOne.checkPassword(userTwo));
    }

    @Test
    public void shouldReturnFalseWhenPasswordOfTwoUserIsDifferent() {
        User userOne = new User("LIB-1233", "Phew123");
        User userTwo = new User("LIB-1133", "Phew113");

        assertNotEquals(true, userOne.checkPassword(userTwo));
    }
}