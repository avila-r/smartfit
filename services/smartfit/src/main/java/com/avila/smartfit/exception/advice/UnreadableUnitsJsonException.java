package com.avila.smartfit.exception.advice;
import org.springframework.http.HttpStatus;

public class UnreadableUnitsJsonException extends RuntimeException {
    public record Response(HttpStatus status, String message){}
    public UnreadableUnitsJsonException(){
        super("Unable to read units at https://test-frontend-developer.s3.amazonaws.com/data/locations.json");
    }
}