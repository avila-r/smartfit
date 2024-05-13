package com.avila.smartfit.exception.schedule.handler;
import com.avila.smartfit.exception.schedule.SchedulesNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ScheduleExceptionsHandler {
    @ExceptionHandler(SchedulesNotFoundException.class)
    ResponseEntity<SchedulesNotFoundException.Response> handleSchedulesNotFoundException(@NotNull SchedulesNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new SchedulesNotFoundException.Response(HttpStatus.NOT_FOUND, e.getMessage()));
    }
}