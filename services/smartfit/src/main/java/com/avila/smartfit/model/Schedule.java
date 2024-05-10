package com.avila.smartfit.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "schedules")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unitId;

    @Column(name = "weekdays", nullable = false)
    private String weekdays;

    @Column(name = "hour", nullable = false)
    private String hour;
}