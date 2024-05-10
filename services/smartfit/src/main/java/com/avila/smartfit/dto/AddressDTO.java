package com.avila.smartfit.dto;
import lombok.Builder;

@Builder
public record AddressDTO (
        Long id,
        String title,
        String street,
        String region,
        String city_name,
        String state_name,
        String uf
) { }