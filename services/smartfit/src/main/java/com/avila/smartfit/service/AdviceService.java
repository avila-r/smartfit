package com.avila.smartfit.service;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.dto.UnitDTO;
import com.avila.smartfit.dto.Locations;
import com.avila.smartfit.exception.advice.UnreadableUnitsJsonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service @AllArgsConstructor
public class AdviceService {
    private final RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper;
    private final UnitService unitService;
    private final AddressService addressService;

    public Locations getUnitListDTO(){
        return getLocations();
    }

    @PostConstruct
    void saveAllUnits(){
        listUnitDTOs().forEach(unitService::saveUnit);
        System.out.println("Saving units...");
    }

    @PostConstruct
    void saveAllAddresses(){
        listAddressDTOs().forEach(addressService::saveAddress);
        System.out.println("Saving addresses...");
    }

    private List<UnitDTO> listUnitDTOs() {
        return getLocations().locations().stream()
                .map(object -> objectMapper.convertValue(object, UnitDTO.class))
                .filter(location -> location.content() != null)
                .toList();
    }

    private List<AddressDTO> listAddressDTOs() {
        return getLocations().locations().stream()
                .map(object -> objectMapper.convertValue(object, AddressDTO.class))
                .filter(address -> address.street() != null)
                .toList();
    }

    private Locations getLocations() {
        try {
            return objectMapper.readValue(restTemplate.getForObject("https://test-frontend-developer.s3.amazonaws.com/data/locations.json", String.class), Locations.class);
        } catch (JsonProcessingException e) {
            throw new UnreadableUnitsJsonException();
        }
    }
}