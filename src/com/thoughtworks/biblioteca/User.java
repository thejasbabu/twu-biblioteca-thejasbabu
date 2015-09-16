// User class represents a user of Biblioteca
package com.thoughtworks.biblioteca;

public class User {
    private String password;
    private String libraryNumber;
    public enum Role {CUSTOMER, LIBRARIAN, INVALID};
    private Role userRole;
    private String userName;
    private String email;
    private String phoneNumber;


    public User(String libraryNumber, String password, Role userRole, String userName, String email, String phoneNumber) {
        this.password = password;
        this.libraryNumber = libraryNumber;
        this.userRole = userRole;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String userDetails() {
        String userDetails = String.format("%-40s%-40s%-40s%-40s\n", libraryNumber, userName, email, phoneNumber);
        return userDetails;
    }

    @Override
    public String toString() {
        return this.libraryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(libraryNumber != null ? !libraryNumber.equals(user.libraryNumber) : user.libraryNumber != null);
    }

    @Override
    public int hashCode() {
        return libraryNumber != null ? libraryNumber.hashCode() : 0;
    }

    public Role getRole() {
        return this.userRole;
    }

    public boolean checkPassword(User thatUser) {
        if(this.password.equals(thatUser.password))
            return true;
        else
            return false;
    }
}
