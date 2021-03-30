package com.example.PizzaApp.exception;

public class UsernameNotFoundException  extends Exception{
    public UsernameNotFoundException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Username not found";
    }
}
