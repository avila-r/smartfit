package com.avila.smartfit.exception.schedule;
import com.avila.smartfit.model.Unit;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

public class SchedulesNotFoundException extends RuntimeException {
    public record Response(HttpStatus status, String message){}

    public SchedulesNotFoundException(@NotNull Unit unit){
        super("Schedules of unit " + unit.getId() + " not found");
    }
}