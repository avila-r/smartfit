package com.avila.smartfit.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private String title;
    private String street;
    private String region;
    private String cityName;
    private String stateName;
    private String uf;
}