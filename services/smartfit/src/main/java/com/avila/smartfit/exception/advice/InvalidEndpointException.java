package com.avila.smartfit.exception.advice;

import org.springframework.http.HttpStatus;

public class InvalidEndpointException extends RuntimeException {
    public record Response(HttpStatus status, String message){}

    public InvalidEndpointException(){
        super("Invalid endpoint. See documentation at https://github.com/avila-r/smartfit to get information.");
    }
}