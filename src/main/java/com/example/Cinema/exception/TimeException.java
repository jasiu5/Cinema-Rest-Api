package com.example.Cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TimeException extends RuntimeException{
    public TimeException(String message){
        super(message);
    }
}
