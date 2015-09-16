// Session represents the user who is currently using the biblioteca
package com.thoughtworks.biblioteca;

public class Session {

    private User user;

    public Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
