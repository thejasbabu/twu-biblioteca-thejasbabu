package com.thoughtworks.biblioteca;


import java.util.ArrayList;

public class ListBook implements Options{

    private Display display;
    private ArrayList<Book> books;

    public ListBook(Display display, ArrayList<Book> books) {
        this.display = display;
        this.books = books;
    }

    @Override
    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NAME\t\tAUTHOR\t\tYEAR\n");
        for(Book book : books)
            stringBuilder.append(book.toString());
        return stringBuilder.toString();
    }
}
