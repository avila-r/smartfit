package com.avila.smartfit.controller;
import com.avila.smartfit.dto.UnitDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/unit")
@AllArgsConstructor
public class UnitController {

    @GetMapping
    public ResponseEntity<UnitDTO> getById(){
        return null;
    }

    @GetMapping
    public ResponseEntity<UnitDTO> getByTitle(){
        return null;
    }

    @PostMapping
    public ResponseEntity<UnitDTO> create(){
        return null;
    }

    @PutMapping
    public ResponseEntity<UnitDTO> update(){
        return null;
    }

    @DeleteMapping
    public void delete(){

    }

    @GetMapping
    public List<ResponseEntity<UnitDTO>> listAll(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<UnitDTO>> listByOpened(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<UnitDTO>> listByClosed(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<UnitDTO>> listByMaskStatus(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<UnitDTO>> listByTowelStatus(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<UnitDTO>> listByFountainStatus(){
        return null;
    }

    @GetMapping
    public List<ResponseEntity<UnitDTO>> listByLockerRoomStatus(){
        return null;
    }
}