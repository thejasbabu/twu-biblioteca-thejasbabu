package com.thoughtworks.biblioteca;


public class Parser {

    public Options parse(String option) {
        if(option.equals("1"))
            return new ListBook();
        else
            return new InvalidOption();
    }
}
