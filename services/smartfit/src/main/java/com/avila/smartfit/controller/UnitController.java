package com.avila.smartfit.controller;
import com.avila.smartfit.dto.UnitDTO;
import com.avila.smartfit.exception.advice.InvalidRequestParamException;
import com.avila.smartfit.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/unit")
@AllArgsConstructor
public class UnitController {
    private final UnitService unitService;

    @GetMapping("/{id}")
    public ResponseEntity<UnitDTO> getUnitByPathVariableId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.getUnitById(id));
    }

    @GetMapping
    public ResponseEntity<UnitDTO> getUnitByRequestParamId(@RequestParam(name = "id") Long id){
        if (id != null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(unitService.getUnitById(id));
        else throw new InvalidRequestParamException("ID cannot be null");
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<UnitDTO> getUnitByTitle(@PathVariable String title){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.getUnitByTitle(title));
    }

    @PostMapping
    public ResponseEntity<UnitDTO> createUnit(@RequestBody UnitDTO request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(unitService.saveUnit(request));
    }

    @PutMapping
    public ResponseEntity<UnitDTO> updateUnit(@RequestBody UnitDTO request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.updateUnit(request));
    }

    @DeleteMapping
    public ResponseEntity<UnitService.DeleteResponse> deleteUnit(@RequestBody UnitDTO request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.deleteUnit(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UnitService.DeleteResponse> deleteUnitById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.deleteUnitById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UnitDTO>> listAllUnits(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.listAllUnits());
    }

    @GetMapping("/opened")
    public ResponseEntity<List<UnitDTO>> listByOpenedUnits(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.listAllOpenedUnits());
    }

    @GetMapping("/closed")
    public ResponseEntity<List<UnitDTO>> listByClosedUnits(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.listAllClosedUnits());
    }

    @GetMapping("/mask/{status}")
    public ResponseEntity<List<UnitDTO>> listUnitsByMaskStatus(@PathVariable String status){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.getUnitsByMaskStatus(status));
    }

    @GetMapping("/towel/{status}")
    public ResponseEntity<List<UnitDTO>> listUnitsByTowelStatus(@PathVariable String status){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.getUnitsByTowelStatus(status));
    }

    @GetMapping("/fountain/{status}")
    public ResponseEntity<List<UnitDTO>> listUnitsByFountainStatus(@PathVariable String status){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.getUnitsByFountainStatus(status));
    }

    @GetMapping("/locker-room/{status}")
    public ResponseEntity<List<UnitDTO>> listUnitsByLockerRoomStatus(@PathVariable String status){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(unitService.getUnitsByLockerRoomStatus(status));
    }
}