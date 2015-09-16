// UserDetailsOption class executes the userdetails method of library
package com.thoughtworks.biblioteca;

public class UserDetailsOption implements Options {

    private User user;

    public UserDetailsOption(User user) {
        this.user = user;
    }

    @Override
    public String execute() {
        StringBuilder userDetails = new StringBuilder();
        String header = String.format("%-40s%-40s%-40s%-40s\n", "LIB_NUMBER", "NAME", "EMAIL", "PHONE-NUMBER");
        userDetails.append(header);
        userDetails.append(user.userDetails());
        return userDetails.toString();
    }
}
