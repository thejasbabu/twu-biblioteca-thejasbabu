package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDetailsOptionTest {

    @Test
    public void shouldReturnListOfUserDetailsWhenCalled() {
        User user = new User("123-3333", "blah1", User.Role.CUSTOMER, "Ozzy", "Ozzy@gmail.com", "9998");
        UserDetailsOption userDetailsOption = new UserDetailsOption(user);

        String userDeatils = String.format("%-40s%-40s%-40s%-40s", "123-3333", "Ozzy", "Ozzy@gmail.com", "9998");
        assertEquals(userDeatils, userDetailsOption.execute());
    }
}