package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void shouldReturnListOfMenuItem() {
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("1. List Book");
        menuItems.add("2. Checkout Book");
        menuItems.add("3. Checkin Book");
        menuItems.add("4. Exit");
        Menu menu = new Menu(menuItems);

        assertEquals("1. List Book\n2. Checkout Book\n3. Checkin Book\n4. Exit\n", menu.toString());
    }
}