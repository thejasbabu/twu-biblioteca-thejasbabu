// Login class executes the authentication of user
package com.thoughtworks.biblioteca;

public class LoginOption implements Options{

    private UserAccount userAccount;
    private Input input;
    private Display display;
    private Session session;

    public LoginOption(UserAccount userAccount, Input input, Display display, Session session) {
        this.userAccount = userAccount;
        this.input = input;
        this.display = display;
        this.session = session;

    }

    @Override
    public String execute() {
        display.display("Enter username:");
        String userName = input.read();
        display.display("Enter password:");
        String password = input.read();
        User user = userAccount.authenticate(userName, password);
        session.setUser(user);
        if(user.getRole().equals(User.Role.INVALID))
            return "Login UnSuccesful\n";
        else
            return "Login Succesful\n";
    }
}
