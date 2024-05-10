package com.avila.smartfit.model;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "addresses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "state_name", nullable = false)
    private String stateName;

    @Column(name = "uf", nullable = false)
    private String uf;
}