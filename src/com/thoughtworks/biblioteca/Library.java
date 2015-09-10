// Library class contains list of books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks;

    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NAME\t\tAUTHOR\t\tYEAR\n");
        for(Book book : availableBooks)
            stringBuilder.append(book.toString());
        return stringBuilder.toString();
    }

    public boolean checkOut(String bookName) {
        Book searchBook = new Book(bookName, "", "");
        for(Book book : availableBooks)
        {
            if(book.equals(searchBook))
            {
                availableBooks.remove(book);
                return true;
            }
        }
        return false;
    }
}
