package com.avila.smartfit.address;
import jakarta.persistence.*;
import lombok.*;

// @Entity @Table(name = "addresses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long id;
    private String title;
    private String street;
    private String region;
    private String city_name;
    private String state_name;
    private String uf;
}