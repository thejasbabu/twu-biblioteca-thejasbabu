package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserAccountTest {

    @Test
    public void shouldReturnUserObjectWithCustomerRoleWhenAValidCutomerIsLoggedIn() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-1234", "Meh123", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        users.add(new User("123-1235", "Meh1234", User.Role.LIBRARIAN, "Osbourne", "Os@gmail.com", "099899"));
        UserAccount userAccount = new UserAccount(users);
        User user = new User("123-1234", "Meh123", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899");

        assertEquals(user, userAccount.authenticate("123-1234", "Meh123"));
    }

    @Test
    public void shouldReturnUserObjectWithLibrarianRoleWhenValidLibrarianIsLoggedIn() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-1234", "Meh123", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        users.add(new User("123-1235", "Meh1234", User.Role.LIBRARIAN, "Osbourne", "Os@gmail.com", "099899"));
        UserAccount userAccount = new UserAccount(users);
        User user = new User("123-1235", "Meh1234", User.Role.LIBRARIAN, "Osbourne", "Os@gmail.com", "099899");

        assertEquals(user, userAccount.authenticate("123-1235", "Meh1234"));
    }

    @Test
    public void shouldReturnUserObejctWithInvalidRoleWhenSomeGuestISLoggedIn() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-1234", "Meh123", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        users.add(new User("123-1235", "Meh1234", User.Role.LIBRARIAN, "Osbourne", "Os@gmail.com", "099899"));
        UserAccount userAccount = new UserAccount(users);
        User user = new User("123-1236", "Meh1235", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899");

        assertEquals(user, userAccount.authenticate("123-1236", "Meh1235"));
    }
}