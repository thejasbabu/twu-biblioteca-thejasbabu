// UserAccount contains list of users of biblioteca and authenticates the users
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class UserAccount {
    private ArrayList<User> users;


    public UserAccount(ArrayList<User> users) {
        this.users = users;
    }

    public User authenticate(String userName, String password) {
        User newUser = new User(userName, password, User.Role.INVALID);
        for (User user : users) {
            if(user.equals(newUser))
            {
                if(user.checkPassword(newUser))
                    return user;
            }
        }
        return newUser;
    }
}