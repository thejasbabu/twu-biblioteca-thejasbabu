package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldReturnTrueWhenUsernameIsSame() {
        User userOne = new User("LIB-1234", "Phew123", User.Role.CUSTOMER);
        User userTwo = new User("LIB-1234", "Phew123", User.Role.CUSTOMER);

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldReturnFalseWhenUsernameIsNotSame() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER);
        User userTwo = new User("LIB-1234", "Phew123", User.Role.CUSTOMER);

        assertNotEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToNull() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER);

        assertNotEquals(null, userOne);
    }

    @Test
    public void shouldReturnTrueWhenPasswordOfTwoUserIsSame() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER);
        User userTwo = new User("LIB-1133", "Phew123", User.Role.CUSTOMER);

        assertEquals(true, userOne.checkPassword(userTwo));
    }

    @Test
    public void shouldReturnFalseWhenPasswordOfTwoUserIsDifferent() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER);
        User userTwo = new User("LIB-1133", "Phew113", User.Role.CUSTOMER);

        assertNotEquals(true, userOne.checkPassword(userTwo));
    }

    @Test
    public void shouldReturnTheRoleOfTheUser() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER);

        assertEquals(User.Role.CUSTOMER, userOne.getRole());
    }
}