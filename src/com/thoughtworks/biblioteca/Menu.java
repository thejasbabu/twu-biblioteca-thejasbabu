// Menu class returns list of menu items.
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> invalidMenuItems;
    private ArrayList<String> customerMenuItems;
    private ArrayList<String> librarianMenuItems;


    public Menu(ArrayList<String> invalidMenuItems, ArrayList<String> customerMenuItems, ArrayList<String> librarianMenuItems) {
        this.invalidMenuItems = invalidMenuItems;
        this.customerMenuItems = customerMenuItems;
        this.librarianMenuItems = librarianMenuItems;
    }


    public String invalidMenu() {
        String menu = "";
        for(String menuOption : invalidMenuItems) {
            menu += menuOption + "\n";
        }
        return menu;
    }

    public String customerMenu() {
        String menu = "";
        for(String menuOption : customerMenuItems) {
            menu += menuOption + "\n";
        }
        return menu;
    }

    public String librarianMenu() {
        String menu = "";
        for(String menuOption : librarianMenuItems) {
            menu += menuOption + "\n";
        }
        return menu;
    }
}
