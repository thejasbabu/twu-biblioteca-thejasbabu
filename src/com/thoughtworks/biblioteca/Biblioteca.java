// Biblioteca class displays the welcome message and contains list of books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<String> books;

    public Biblioteca(ArrayList<String> books) {
        this.books = books;
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Welcome to Biblioteca\n");
        for(String bookName : books)
            stringBuilder.append(bookName + "\n");
        return stringBuilder.toString();
    }
}
