package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InputTest {

    String userChoice = "Hello";
    final ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());

    @Before
    public void setUp()
    {
        System.setIn(inContent);
    }
    @Test
    public void shouldReturnTheInputGivenByTheUser() {
        Input input = new Input(new Scanner(System.in));
        assertEquals("Hello", input.read());
    }
}