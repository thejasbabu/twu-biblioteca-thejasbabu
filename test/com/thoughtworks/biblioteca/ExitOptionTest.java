package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class ExitOptionTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitFromTheApplication() {
        ExitOption exitOption = new ExitOption();
        exit.expectSystemExitWithStatus(0);

        exitOption.execute(new Session(new User("XXX", "XXX", User.Role.INVALID)));
    }
}