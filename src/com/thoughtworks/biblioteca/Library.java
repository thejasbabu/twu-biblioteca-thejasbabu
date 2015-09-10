// Library class contains list of books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NAME\t\tAUTHOR\t\tYEAR\n");
        for(Book book : books)
            stringBuilder.append(book.toString());
        return stringBuilder.toString();
    }
}
