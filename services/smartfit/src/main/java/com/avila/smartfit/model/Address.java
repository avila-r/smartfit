package com.avila.smartfit.model;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "addresses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id private Long id;
    private String title;
    private String street;
    private String region;
    private String cityName;
    private String stateName;
    private String uf;
}