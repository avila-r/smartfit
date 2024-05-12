package com.avila.smartfit.controller;
import com.avila.smartfit.dto.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    @GetMapping
    public ResponseEntity<AddressDTO> getById(){
        return null;
    }

    @GetMapping
    public ResponseEntity<AddressDTO> getByTitle(){
        return null;
    }

    @GetMapping
    public ResponseEntity<AddressDTO> getByStreet(){
        return null;
    }

    @PostMapping
    public ResponseEntity<AddressDTO> create(){
        return null;
    }

    @PutMapping
    public ResponseEntity<AddressDTO> update(){
        return null;
    }

    @DeleteMapping
    public void delete(){

    }

    @GetMapping
    public List<ResponseEntity<AddressDTO>> listAll(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<AddressDTO>> listByRegion(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<AddressDTO>> listByCityName(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<AddressDTO>> listByStateName(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<AddressDTO>> listByUf(){
        return null;
    }
}