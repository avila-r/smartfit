package com.avila.smartfit.controller;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.dto.UnitDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/unit")
@AllArgsConstructor
public class UnitController {

    @GetMapping("/{id}")
    public ResponseEntity<UnitDTO> getUnitByPathVariableId(@PathVariable Long id){
        return null;
    }

    @GetMapping
    public ResponseEntity<AddressDTO> getUnitByRequestParamId(
            @RequestParam(name = "id") Long id
    ){
        if (id != null) return null; else throw new RuntimeException(); // TODO: Custom exception
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<UnitDTO> getUnitByTitle(@PathVariable String title){
        return null;
    }

    @PostMapping
    public ResponseEntity<UnitDTO> createUnit(){
        return null;
    }

    @PutMapping
    public ResponseEntity<UnitDTO> updateUnit(){
        return null;
    }

    @DeleteMapping
    public void deleteUnit(){

    }

    @DeleteMapping("/{id}")
    public void deleteUnitById(@PathVariable Long id){

    }

    @GetMapping("/list")
    public List<ResponseEntity<UnitDTO>> listAllUnits(){
        return null;
    }

    @GetMapping("/opened")
    public List<ResponseEntity<UnitDTO>> listByOpenedUnits(){
        return null;
    }

    @GetMapping("/closed")
    public List<ResponseEntity<UnitDTO>> listByClosedUnits(){
        return null;
    }

    @GetMapping("/mask/{status}")
    public List<ResponseEntity<UnitDTO>> listUnitsByMaskStatus(@PathVariable String status){
        return null;
    }

    @GetMapping("/towel/{status}")
    public List<ResponseEntity<UnitDTO>> listUnitsByTowelStatus(@PathVariable String status){
        return null;
    }

    @GetMapping("/fountain/{status}")
    public List<ResponseEntity<UnitDTO>> listUnitsByFountainStatus(@PathVariable String status){
        return null;
    }

    @GetMapping("/locker-room/{status}")
    public List<ResponseEntity<UnitDTO>> listUnitsByLockerRoomStatus(@PathVariable String status){
        return null;
    }
}