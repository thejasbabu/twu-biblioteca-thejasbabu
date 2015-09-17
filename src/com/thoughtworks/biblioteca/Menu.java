// Menu class returns list of menu items.
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> menuItems;

    public Menu(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        String menu = "";
        for(String menuOption : menuItems) {
            menu += menuOption + "\n";
        }
        return menu;
    }
}
