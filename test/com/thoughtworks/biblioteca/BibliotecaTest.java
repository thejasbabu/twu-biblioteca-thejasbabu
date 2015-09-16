package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaTest {

    @Test
    public void shouldDisplayCustomerMenuOptionsWhenCustomerLogsIn() {
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        MenuFactory menuFactory = new MenuFactory();
        ListBookOption listBookOption = mock(ListBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.CUSTOMER, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);

        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute()).thenReturn("listBookOption Called");
        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1. List Book");
        menuList.add("2. Checkout Book");
        menuList.add("3. Return Book");
        menuList.add("4. Exit");
        menuList.add("5. List Movie");
        menuList.add("6. Checkout Movie");
        menuList.add("8. Logout");
        menuList.add("10. User Details");
        Menu menu = new Menu(menuList);
        biblioteca.run();

        verify(display).display(menu.toString());
    }

    @Test
    public void shouldDisplayLibrarianMenuOptionsWhenCustomerLogsIn() {
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        MenuFactory menuFactory = new MenuFactory();
        ListBookOption listBookOption = mock(ListBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.LIBRARIAN, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);

        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1. List Book");
        menuList.add("2. Checkout Book");
        menuList.add("3. Return Book");
        menuList.add("4. Exit");
        menuList.add("5. List Movie");
        menuList.add("6. Checkout Movie");
        menuList.add("8. Logout");
        menuList.add("9. Book details");
        Menu menu = new Menu(menuList);
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute()).thenReturn("listBookOption Called");
        biblioteca.run();

        verify(display).display(menu.toString());
    }

    @Test
    public void shouldDisplayInvalidMenuOptionsWhenAGuestLogsIn() {
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        MenuFactory menuFactory = new MenuFactory();
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);

        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute()).thenReturn("List Book Option");
        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1. List Book");
        menuList.add("4. Exit");
        menuList.add("5. List Movie");
        menuList.add("6. Checkout Movie");
        menuList.add("7. Login");
        Menu menu = new Menu(menuList);
        biblioteca.run();

        verify(display).display(menu.toString());
    }


    @Test
    public void shouldDisplayInvalidOptionWhenUserEntersInvalidChoice() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        InvalidOption invalidOption = mock(InvalidOption.class);
        MenuFactory menuFactory = new MenuFactory();
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);

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
        MenuFactory menuFactory = new MenuFactory();
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);

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
        MenuFactory menuFactory = new MenuFactory();
        CheckOutBookOption checkOutBookOption = mock(CheckOutBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);

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
        MenuFactory menuFactory = new MenuFactory();
        ReturnBookOption returnBookOption = mock(ReturnBookOption.class);
        Session session = new Session(new User("123-333", "blah", User.Role.INVALID, "Osbourne", "Os@gmail.com", "099899"));
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menuFactory, session);

        when(input.read()).thenReturn("3");
        when(parser.parse("3")).thenReturn(returnBookOption);
        biblioteca.run();

        verify(returnBookOption).execute();
    }
}