package com.avila.smartfit.exception.address;
import org.springframework.http.HttpStatus;

public class AddressNotFoundException extends RuntimeException {
    public record Response(HttpStatus status, String message){}

    public AddressNotFoundException(){
        super("Address not found");
    }
}