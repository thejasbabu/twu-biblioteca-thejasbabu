package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDetailsOptionTest {

    @Test
    public void shouldReturnListOfUserDetailsWhenCalled() {
        User user = new User("123-3333", "blah1", User.Role.CUSTOMER, "Ozzy", "Ozzy@gmail.com", "9998");
        UserDetailsOption userDetailsOption = new UserDetailsOption(user);

        String header = String.format("%-20s%-20s%-20s%-20s\n", "LIB_NUMBER", "NAME", "EMAIL", "PHONE-NUMBER");
        String userDeatils = String.format("%-20s%-20s%-20s%-20s\n", "123-3333", "Ozzy", "Ozzy@gmail.com", "9998");
        assertEquals(header + userDeatils, userDetailsOption.execute());
    }
}