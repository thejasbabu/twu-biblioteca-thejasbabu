// Menu factory will generate the appropriate menu
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MenuFactory {

    public Menu getMenu(User.Role role) {
        ArrayList<String> menuList = new ArrayList<String>();
        if(role.equals(User.Role.INVALID)) {
            menuList.add("1. List Book");
            menuList.add("4. Exit");
            menuList.add("5. List Movie");
            menuList.add("6. Checkout Movie");
            menuList.add("7. Login");
            Menu menu = new Menu(menuList);
            return menu;
        }
        else if(role.equals(User.Role.CUSTOMER)) {
            menuList.add("1. List Book");
            menuList.add("2. Checkout Book");
            menuList.add("3. Return Book");
            menuList.add("4. Exit");
            menuList.add("5. List Movie");
            menuList.add("6. Checkout Movie");
            menuList.add("8. Logout");
            menuList.add("10. User Details");
            Menu menu = new Menu(menuList);
            return menu;
        }
        else
        {
            menuList.add("1. List Book");
            menuList.add("2. Checkout Book");
            menuList.add("3. Return Book");
            menuList.add("4. Exit");
            menuList.add("5. List Movie");
            menuList.add("6. Checkout Movie");
            menuList.add("8. Logout");
            menuList.add("9. Book details");
            Menu menu = new Menu(menuList);
            return menu;
        }
    }
}
