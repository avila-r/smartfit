package com.avila.smartfit.dto;
import lombok.*;

import java.util.List;

@Data
@Builder
@Getter @Setter
public class UnitDTO {
    private Long id;
    private String title;
    private String content;
    private boolean opened;
    private String mask;
    private String towel;
    private String fountain;
    private String locker_room;
    private List<ScheduleDTO> schedules;
}