package com.example.PizzaApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFoundException  extends Exception{
    public UsernameNotFoundException(String s) {
        super(s);
    }
}
