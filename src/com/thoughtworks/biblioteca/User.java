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

        if (!password.equals(user.password)) return false;
        return username.equals(user.username);

    }

    @Override
    public int hashCode() {
        int result = password.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }
}
