// Library class contains list of books and performs checkin,checkout tasks.
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
        checkedOutBooks = new ArrayList<Book>();
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
        for(Book book : availableBooks) {
            if(book.equals(searchBook))
            {
                availableBooks.remove(book);
                checkedOutBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean checkIn(String bookName) {
        Book searchBook = new Book(bookName, "", "");
        for(Book book : checkedOutBooks) {
            if(book.equals(searchBook)){
                checkedOutBooks.remove(book);
                availableBooks.add(book);
                return true;
            }
        }
        return false;
    }
}
