package com.avila.smartfit.exception.advice;
import org.springframework.http.HttpStatus;

public class InvalidRequestParamException extends RuntimeException {
    public record Response(HttpStatus status, String message){}

    public InvalidRequestParamException(String message) {
        super(message);
    }
}