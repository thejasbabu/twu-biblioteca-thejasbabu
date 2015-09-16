// Logout class performs the logout operation
package com.thoughtworks.biblioteca;

public class LogoutOption implements Options{
    private Session session;

    public LogoutOption(Session session) {
        this.session = session;
    }

    @Override
    public String execute() {
        session.setUser(getNewUser());
        return "Thank You!\n";
    }

     User getNewUser() {
        User user = new User("XXX", "XXX", User.Role.INVALID, "", "", "");
        return user;
    }
}
