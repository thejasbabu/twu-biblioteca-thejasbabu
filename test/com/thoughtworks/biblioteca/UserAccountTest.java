package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserAccountTest {

    @Test
    public void shouldReturnUserObjectWithCustomerRoleWhenAValidCutomerIsLoggedIn() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("LIB-1234", "Meh123", User.Role.CUSTOMER));
        users.add(new User("LIB-1235", "Meh1234", User.Role.LIBRARIAN));
        users.add(new User("LIB-1236", "Meh1235", User.Role.INVALID));
        UserAccount userAccount = new UserAccount(users);
        User user = new User("LIB-1234", "Meh123", User.Role.CUSTOMER);

        assertEquals(user, userAccount.authenticate("LIB-1234", "Meh123"));
    }

    @Test
    public void shouldReturnUserObjectWithLibrarianRoleWhenValidLibrarianIsLoggedIn() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("LIB-1234", "Meh123", User.Role.CUSTOMER));
        users.add(new User("LIB-1235", "Meh1234", User.Role.LIBRARIAN));
        users.add(new User("LIB-1236", "Meh1235", User.Role.INVALID));
        UserAccount userAccount = new UserAccount(users);

        User user = new User("LIB-1235", "Meh1234", User.Role.LIBRARIAN);

        assertEquals(user, userAccount.authenticate("LIB-1235", "Meh1234"));
    }

    @Test
    public void shouldReturnUserObejctWithInvalidRoleWhenSomeGuestISLoggedIn() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("LIB-1234", "Meh123", User.Role.CUSTOMER));
        users.add(new User("LIB-1235", "Meh1234", User.Role.LIBRARIAN));
        users.add(new User("LIB-1236", "Meh1235", User.Role.INVALID));
        UserAccount userAccount = new UserAccount(users);

        User user = new User("LIB-1236", "Meh1235", User.Role.INVALID);

        assertEquals(user, userAccount.authenticate("LIB-1236", "Meh1235"));
    }
}