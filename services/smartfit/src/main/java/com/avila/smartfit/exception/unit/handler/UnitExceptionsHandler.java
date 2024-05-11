package com.avila.smartfit.exception.unit.handler;
import com.avila.smartfit.exception.unit.UnitNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UnitExceptionsHandler {
    @ExceptionHandler(UnitNotFoundException.class)
    ResponseEntity<UnitNotFoundException.Response> handleUnitNotFoundException(@NotNull UnitNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new UnitNotFoundException.Response(HttpStatus.NOT_FOUND, e.getMessage()));
    }
}