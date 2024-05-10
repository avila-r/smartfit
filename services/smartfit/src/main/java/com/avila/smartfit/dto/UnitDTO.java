package com.avila.smartfit.dto;
import lombok.Builder;
import java.util.List;

@Builder
public record UnitDTO (
        Long id,
        String title,
        String content,
        boolean opened,
        String mask,
        String towel,
        String fountain,
        String locker_room,
        List<ScheduleDTO> schedules
) { }