package com.avila.smartfit.exception.address.handler;
import com.avila.smartfit.exception.address.AddressNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressExceptionsHandler {
    @ExceptionHandler(AddressNotFoundException.class)
    ResponseEntity<AddressNotFoundException.Response> handleAddressNotFoundException(@NotNull AddressNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new AddressNotFoundException.Response(HttpStatus.NOT_FOUND, e.getMessage()));
    }

}