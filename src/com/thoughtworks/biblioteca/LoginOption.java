// Login class executes the authentication of user
package com.thoughtworks.biblioteca;

public class LoginOption implements Options{

    private UserAccount userAccount;
    private Input input;
    private Display display;

    public LoginOption(UserAccount userAccount, Input input, Display display) {
        this.userAccount = userAccount;
        this.input = input;
        this.display = display;
    }

    @Override
    public String execute(Session session) {
        display.display("Enter username:");
        String userName = input.read();
        display.display("Enter password:");
        String password = input.read();
        User user = userAccount.authenticate(userName, password);
        session = new Session(user);
        if(user.getRole().equals(User.Role.INVALID))
            return "Login UnSuccesful\n";
        else
            return "Login Succesful\n";
    }
}
