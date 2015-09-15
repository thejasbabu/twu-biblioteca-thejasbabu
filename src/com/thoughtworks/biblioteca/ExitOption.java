// ExitOption class handles the System.exit() method.
package com.thoughtworks.biblioteca;

public class ExitOption implements Options {

    @Override
    public String execute(Session session) {
        System.exit(0);
        return "EXIT";
    }
}
