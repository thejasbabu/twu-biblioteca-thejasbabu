package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DisplayTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldDisplayTheMessageWhichIsSentToTheScreen() {
        Display display = new Display(new PrintStream(System.out));

        display.display("Welcome");

        assertEquals("Welcome", outContent.toString());
    }

    @After
    public void cleanUp() {
        System.setOut(System.out);
    }
}