package com.avila.smartfit.controller;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.dto.UnitDTO;
import com.avila.smartfit.service.AddressService;
import com.avila.smartfit.service.AdviceService;
import com.avila.smartfit.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/unit")
@AllArgsConstructor
public class UnitController {
    private final AdviceService adviceService;
    private final UnitService unitService;
    private final AddressService addressService;

    @GetMapping("/save-all-units")
    public ResponseEntity<List<UnitDTO>> saveUnit(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(adviceService.listUnitDTOs().stream()
                        .map(unitService::saveUnit)
                        .toList()
                );
    }

    @GetMapping("/save-all-addresses")
    public ResponseEntity<List<AddressDTO>> list(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(adviceService.listAddressDTOs().stream()
                        .map(addressService::saveAddress)
                        .toList()
                );
    }
}