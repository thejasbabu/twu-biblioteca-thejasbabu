// User class represents a user of Biblioteca
package com.thoughtworks.biblioteca;

public class User {
    private String password;
    private String username;


    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(username != null ? !username.equals(user.username) : user.username != null);

    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    public boolean checkPassword(User thatUser) {
        if(this.password.equals(thatUser.password))
            return true;
        else
            return false;
    }
}
