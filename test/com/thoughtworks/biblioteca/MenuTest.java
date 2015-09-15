package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void shouldReturnListOfMenuItemForInvalid() {
        ArrayList<String> invalidMenu = new ArrayList<String>();
        ArrayList<String> customerMenu = new ArrayList<String>();
        ArrayList<String> librarian = new ArrayList<String>();
        invalidMenu.add("1. List Book");
        invalidMenu.add("2. Checkout Movie");
        invalidMenu.add("3. Login");
        invalidMenu.add("4. Exit");
        Menu menu = new Menu(invalidMenu, customerMenu, librarian);

        assertEquals("1. List Book\n2. Checkout Movie\n3. Login\n4. Exit\n", menu.invalidMenu());
    }

    @Test
    public void shouldReturnListOfMenuItemForCustomer() {
        ArrayList<String> invalidMenu = new ArrayList<String>();
        ArrayList<String> customerMenu = new ArrayList<String>();
        ArrayList<String> librarian = new ArrayList<String>();
        customerMenu.add("1. List Book");
        customerMenu.add("2. Checkout Book");
        customerMenu.add("3. Checkin Book");
        customerMenu.add("4. Exit");
        customerMenu.add("5. Logout");
        Menu menu = new Menu(invalidMenu, customerMenu, librarian);

        assertEquals("1. List Book\n2. Checkout Book\n3. Checkin Book\n4. Exit\n5. Logout\n", menu.customerMenu());
    }
}