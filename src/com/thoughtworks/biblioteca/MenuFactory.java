package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MenuFactory {

    public Menu getMenu(User.Role role) {
        if(role.equals(User.Role.CUSTOMER)) {
            ArrayList<String> menuList = new ArrayList<String>();
            menuList.add("1. List Book");
            menuList.add("4. Exit");
            menuList.add("5. List Movie");
            menuList.add("6. Checkout Movie");
            menuList.add("7. Login");
            Menu menu = new Menu(menuList);
            return menu;
        }
        else
            return new Menu(new ArrayList<String>());
    }
}
