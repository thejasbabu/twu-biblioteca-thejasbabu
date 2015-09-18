package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuFactoryTest {

    @Test
    public void shouldReturnInvalidMenuItemWhenUserIsInvalid() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1. List Book");
        menuList.add("2. List Movie");
        menuList.add("3. Checkout Movie");
        menuList.add("8. Login");
        menuList.add("0. Exit");
        Menu menu = new Menu(menuList);

        assertEquals(menu.toString(), menuFactory.getMenu(User.Role.INVALID).toString());
    }

    @Test
    public void shouldReturnCustomerMenuWhenUserIsCustomer() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1. List Book");
        menuList.add("2. List Movie");
        menuList.add("3. Checkout Movie");
        menuList.add("4. Checkout Book");
        menuList.add("5. Return Book");
        menuList.add("6. User Details");
        menuList.add("9. Logout");
        menuList.add("0. Exit");
        Menu menu = new Menu(menuList);

        assertEquals(menu.toString(), menuFactory.getMenu(User.Role.CUSTOMER).toString());
    }

    @Test
    public void shouldReturnLibrarianMenuWhenUserIsLibrarian() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1. List Book");
        menuList.add("2. List Movie");
        menuList.add("3. Checkout Movie");
        menuList.add("4. Checkout Book");
        menuList.add("5. Return Book");
        menuList.add("6. User Details");
        menuList.add("7. Book details");
        menuList.add("9. Logout");
        menuList.add("0. Exit");
        Menu menu = new Menu(menuList);

        assertEquals(menu.toString(), menuFactory.getMenu(User.Role.LIBRARIAN).toString());

    }
}