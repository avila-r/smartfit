package com.avila.smartfit.exception.unit;

import org.springframework.http.HttpStatus;

public class UnitNotFoundException extends RuntimeException {
    public record Response(HttpStatus status, String message){}
    public UnitNotFoundException(){
        super("Unit not found");
    }
}
