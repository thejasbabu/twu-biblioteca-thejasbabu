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
        String userDetails = String.format("%-20s%-20s%-20s%-20s\n", libraryNumber, userName, email, phoneNumber);
        return userDetails;
    }

    @Override
    public String toString() {
        String details = String.format("%-20s%-20s%-20s", this.libraryNumber, this.userName, this.phoneNumber);
        return details;
    }

    @Override
    public boolean equals(Object thatUser) {
        if (this == thatUser) return true;
        if (thatUser == null || getClass() != thatUser.getClass()) return false;

        User user = (User) thatUser;

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
