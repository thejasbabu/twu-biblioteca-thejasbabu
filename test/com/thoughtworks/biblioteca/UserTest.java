package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldReturnTrueWhenUsernameIsSame() {
        User userOne = new User("LIB-1234", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@mail.com", "998898");
        User userTwo = new User("LIB-1234", "Phew123", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldReturnFalseWhenUsernameIsNotSame() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@gmail.com", "998898");
        User userTwo = new User("LIB-1234", "Phew123", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899");

        assertNotEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToNull() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@mail.com", "998898");

        assertNotEquals(null, userOne);
    }

    @Test
    public void shouldReturnTrueWhenPasswordOfTwoUserIsSame() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@mail.com", "998898");
        User userTwo = new User("LIB-1133", "Phew123", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899");

        assertEquals(true, userOne.checkPassword(userTwo));
    }

    @Test
    public void shouldReturnFalseWhenPasswordOfTwoUserIsDifferent() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@mail.com", "998898");
        User userTwo = new User("LIB-1133", "Phew113", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899");

        assertNotEquals(true, userOne.checkPassword(userTwo));
    }

    @Test
    public void shouldReturnTheRoleOfTheUser() {
        User userOne = new User("LIB-1233", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@mail.com", "998898");

        assertEquals(User.Role.CUSTOMER, userOne.getRole());
    }

    @Test
    public void shouldReturnDetailsOfUser() {
        User user = new User("LIB-1233", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@gmail.com", "998898");
        String userDetails = String.format("%-40s%-40s%-40s%-40s\n", "LIB-1233", "Ozzy", "Ozzy@gmail.com", "998898");

        assertEquals(userDetails, user.userDetails());
    }

    @Test
    public void shouldReturnFalseWhenUserIsComparedToNull() {
        User user = new User("LIB-1233", "Phew123", User.Role.CUSTOMER, "Ozzy", "Ozzy@gmail.com", "998898");

        assertEquals(false, user.equals(null));
    }
}