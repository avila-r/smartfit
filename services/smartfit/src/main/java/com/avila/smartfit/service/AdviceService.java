package com.avila.smartfit.service;
import com.avila.smartfit.contract.AdviceJsonServiceContract;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.dto.ScheduleDTO;
import com.avila.smartfit.dto.UnitDTO;
import com.avila.smartfit.dto.UnitListDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service @AllArgsConstructor
public class AdviceService implements AdviceJsonServiceContract {
    private final RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper;

    @Override
    public ResponseEntity<List<UnitDTO>> listUnitDTOs() {
        return ResponseEntity.ok(
                getLocationDTO().locations().stream()
                        .map(object -> objectMapper.convertValue(object, UnitDTO.class))
                        .filter(location -> location.getContent() != null)
                        .toList()
        );
    }

    @Override
    public ResponseEntity<List<AddressDTO>> listAddressDTOs() {
        return ResponseEntity.ok(
                getLocationDTO().locations().stream()
                        .map(object -> objectMapper.convertValue(object, AddressDTO.class))
                        .filter(address -> address.getStreet() != null)
                        .toList()
        );
    }

    @Override
    public ResponseEntity<List<ScheduleDTO>> getScheduleDTO(@NotNull UnitDTO unitDTO){
        return ResponseEntity.ok(
            unitDTO.getSchedules()
        );
    }

    private UnitListDTO getLocationDTO() {
        try {
            return objectMapper.readValue(restTemplate.getForObject("https://test-frontend-developer.s3.amazonaws.com/data/locations.json", String.class), UnitListDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e); // TODO: Custom exception
        }
    }
}