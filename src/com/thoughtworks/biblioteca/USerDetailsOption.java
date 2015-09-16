// UserDetailsOption class executes the userdetails method of library
package com.thoughtworks.biblioteca;

public class UserDetailsOption implements Options {

    private User user;

    public UserDetailsOption(User user) {
        this.user = user;
    }

    @Override
    public String execute() {
        String userDetails;
        userDetails = user.userDetails();
        return userDetails;
    }
}
