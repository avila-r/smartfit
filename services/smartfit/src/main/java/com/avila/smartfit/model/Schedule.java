package com.avila.smartfit.schedule;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "schedules")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id private Long id;
    private Long locationId;
    private String weekdays;
    private String hour;
}