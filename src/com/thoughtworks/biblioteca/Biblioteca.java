// Biblioteca class displays the welcome message and contains list of books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private ArrayList<Book> books;

    public Biblioteca(ArrayList<Book> books) {
        this.books = books;
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Welcome to Biblioteca\n");
        Input input = new Input(new Scanner(System.in));
        String option = input.read();
        stringBuilder.append("NAME\t\tAUTHOR\t\tYEAR\n");
        for(Book book : books)
            stringBuilder.append(book.toString());
        return stringBuilder.toString();
    }
}
