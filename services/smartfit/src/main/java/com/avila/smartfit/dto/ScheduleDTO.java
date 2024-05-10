package com.avila.smartfit.dto;
import lombok.Builder;

@Builder
public record ScheduleDTO (String weekdays, String hour) { }