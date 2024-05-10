package com.avila.smartfit.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "units")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Unit {
    @Id private Long id;
    private String title;
    private String content;
    private boolean isOpened;
    private String maskStatus;
    private String towelStatus;
    private String fountainStatus;
    private String lockerRoomStatus;
}