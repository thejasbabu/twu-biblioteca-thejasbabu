package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuFactoryTest {

    @Test
    public void shouldReturnCustomerMenuItemWhenUserISCustomer() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1. List Book");
        menuList.add("4. Exit");
        menuList.add("5. List Movie");
        menuList.add("6. Checkout Movie");
        menuList.add("7. Login");
        Menu menu = new Menu(menuList);

        assertEquals(menu.toString(), menuFactory.getMenu(User.Role.CUSTOMER).toString());
    }
    
}