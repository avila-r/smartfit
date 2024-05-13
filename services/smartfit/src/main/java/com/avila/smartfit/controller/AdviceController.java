package com.avila.smartfit.controller;
import com.avila.smartfit.dto.Locations;
import com.avila.smartfit.exception.advice.InvalidEndpointException;
import com.avila.smartfit.service.AdviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdviceController {
    private final AdviceService adviceService;

    @RequestMapping("**")
    void handleInvalidEndpoint(){
        throw new InvalidEndpointException();
    }

    @GetMapping("/locations")
    public Locations getAllLocations(){
        return adviceService.getUnitListDTO();
    }
}