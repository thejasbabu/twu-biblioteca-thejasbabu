package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class BibliotecaTest {

    @Test
    public void shouldDisplayCustomerMenuOptionsWhenCustomerLogsIn() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(menu.toString()).thenReturn("Customer Menu Called");
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute()).thenReturn("listBookOption Called");

        biblioteca.run();

        verify(display).display("Customer Menu Called");
    }

    @Test
    public void shouldDisplayLibrarianMenuOptionsWhenCustomerLogsIn() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.LIBRARIAN, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(menu.toString()).thenReturn("Libraian Menu Called");
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute()).thenReturn("listBookOption Called");

        biblioteca.run();

        verify(display).display("Libraian Menu Called");
    }

    @Test
    public void shouldDisplayInvalidMenuOptionsWhenAGuestLogsIn() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(menu.toString()).thenReturn("Invalid Menu Called");
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute()).thenReturn("List Book Option");

        biblioteca.run();

        verify(display).display("Invalid Menu Called");
    }


    @Test
    public void shouldDisplayInvalidOptionWhenUserEntersInvalidChoice() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        InvalidOption invalidOption = mock(InvalidOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("Biblioteca");
        when(parser.parse("Biblioteca")).thenReturn(invalidOption);
        biblioteca.run();

        verify(invalidOption).execute();
    }

    @Test
    public void shouldExitFromTheApplicationWhenExitOptionIsSelected() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ExitOption exitOption = mock(ExitOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("4");
        when(parser.parse("4")).thenReturn(exitOption);

        biblioteca.run();
        verify(exitOption).execute();
    }

    @Test
    public void shouldExecuteCheckOutOptionWhenUserEntersTwoAsTheirChoice() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        CheckOutBookOption checkOutBookOption = mock(CheckOutBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("2");
        when(parser.parse("2")).thenReturn(checkOutBookOption);
        biblioteca.run();

        verify(checkOutBookOption).execute();
    }

    @Test
    public void shouldExecuteCheckInOptionWhenUserEntersThreeAsTheirChoice() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ReturnBookOption returnBookOption = mock(ReturnBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("3");
        when(parser.parse("3")).thenReturn(returnBookOption);
        biblioteca.run();

        verify(returnBookOption).execute();
    }
}