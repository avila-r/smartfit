package com.avila.smartfit.exception.advice.handler;
import com.avila.smartfit.exception.advice.InvalidEndpointException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceExceptionHandler {
    @ExceptionHandler(InvalidEndpointException.class)
    ResponseEntity<InvalidEndpointException.Response> handleInvalidEndpointException(@NotNull InvalidEndpointException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new InvalidEndpointException.Response(HttpStatus.NOT_FOUND, e.getMessage()));
    }
}