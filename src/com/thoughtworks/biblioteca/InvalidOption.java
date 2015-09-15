// InvalidOption class returns the invalid message back to display in the screen
package com.thoughtworks.biblioteca;

public class InvalidOption implements Options{

    @Override
    public String execute(Session session) {
       return "Invalid Option\n";
    }
}
