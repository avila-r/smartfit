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
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_opened", nullable = false)
    private boolean isOpened;

    @Column(name = "mask_status", nullable = false)
    private String maskStatus;

    @Column(name = "towel_status", nullable = false)
    private String towelStatus;

    @Column(name = "fountain_status", nullable = false)
    private String fountainStatus;

    @Column(name = "locker_room_status", nullable = false)
    private String lockerRoomStatus;
}