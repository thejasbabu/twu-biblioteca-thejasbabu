// Menu factory will generate the appropriate menu
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MenuFactory {

    public Menu getMenu(User.Role role) {
        ArrayList<String> menuList = new ArrayList<String>();
        if(role.equals(User.Role.INVALID)) {
            menuList.add("1. List Book");
            menuList.add("2. List Movie");
            menuList.add("3. Checkout Movie");
            menuList.add("8. Login");
            menuList.add("0. Exit");
            Menu menu = new Menu(menuList);
            return menu;
        }
        else if(role.equals(User.Role.CUSTOMER)) {
            menuList.add("1. List Book");
            menuList.add("2. List Movie");
            menuList.add("3. Checkout Movie");
            menuList.add("4. Checkout Book");
            menuList.add("5. Return Book");
            menuList.add("6. User Details");
            menuList.add("9. Logout");
            menuList.add("0. Exit");
            Menu menu = new Menu(menuList);
            return menu;
        }
        else
        {
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
            return menu;
        }
    }
}
