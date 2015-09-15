package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class BibliotecaTest {

    @Test
    public void shouldDisplayMenuOptionsAlongWithWelcomeMessage() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        Session session = mock(Session.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(menu.toString()).thenReturn("Menu Called");
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute(session)).thenReturn("listBookOption Called");

        biblioteca.run();

        verify(display).display("Menu Called");
    }

    @Test
    public void shouldDisplayListOfBooksWhenUserEntersOptionOne() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ListBookOption listBookOption = mock(ListBookOption.class);
        Session session = mock(Session.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("1");
        when(parser.parse("1")).thenReturn(listBookOption);
        when(listBookOption.execute(session)).thenReturn("List Book Option");

        biblioteca.run();

        verify(display).display("List Book Option");
    }


    @Test
    public void shouldDisplayInvalidOptionWhenUserEntersInvalidChoice() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        InvalidOption invalidOption = mock(InvalidOption.class);
        Session session = mock(Session.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("Biblioteca");
        when(parser.parse("Biblioteca")).thenReturn(invalidOption);
        biblioteca.run();

        verify(invalidOption).execute(session);
    }

    @Test
    public void shouldExitFromTheApplicationWhenExitOptionIsSelected() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ExitOption exitOption = mock(ExitOption.class);
        Session session = mock(Session.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("4");
        when(parser.parse("4")).thenReturn(exitOption);

        biblioteca.run();
        verify(exitOption).execute(session);
    }

    @Test
    public void shouldExecuteCheckOutOptionWhenUserEntersTwoAsTheirChoice() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        CheckOutBookOption checkOutBookOption = mock(CheckOutBookOption.class);
        Session session = mock(Session.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("2");
        when(parser.parse("2")).thenReturn(checkOutBookOption);
        biblioteca.run();

        verify(checkOutBookOption).execute(session);
    }

    @Test
    public void shouldExecuteCheckInOptionWhenUserEntersThreeAsTheirChoice() {
        Menu menu = mock(Menu.class);
        Display display = mock(Display.class);
        Input input = mock(Input.class);
        Parser parser = mock(Parser.class);
        ReturnBookOption returnBookOption = mock(ReturnBookOption.class);
        Session session = mock(Session.class);
        Biblioteca biblioteca = new Biblioteca(display, input, parser, menu, session);
        when(input.read()).thenReturn("3");
        when(parser.parse("3")).thenReturn(returnBookOption);
        biblioteca.run();

        verify(returnBookOption).execute(session);
    }
}