package com.avila.smartfit.dto;
import java.util.List;

public record Locations(
        Long current_country_id,
        List<Object> locations,
        int wp_total,
        int total,
        boolean success
) { }