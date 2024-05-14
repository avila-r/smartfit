package com.avila.smartfit.controller;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.exception.advice.InvalidRequestParamException;
import com.avila.smartfit.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressByPathVariableId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddressById(id));
    }

    @GetMapping
    public ResponseEntity<AddressDTO> getAddressByRequestParamId(@RequestParam(name = "id") Long id){
        if (id != null)
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddressById(id));
        else throw new InvalidRequestParamException("ID cannot be null");
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<AddressDTO> getAddressByTitle(@PathVariable String title){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddressByTitle(title));
    }

    @GetMapping("/street/{street}")
    public ResponseEntity<AddressDTO> getAddressByStreet(@PathVariable String street){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddressByStreet(street));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressService.saveAddress(request));
    }

    @PutMapping
    public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.updateAddress(request));
    }

    @DeleteMapping
    public ResponseEntity<AddressService.DeleteResponse> deleteAddress(@RequestBody AddressDTO request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.deleteAddress(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressService.DeleteResponse> deleteAddressById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.deleteAddressById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<AddressDTO>> listAllAddresses(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.listAllAddresses());
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<AddressDTO>> listAddressesByRegion(@PathVariable String region){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.listAddressesByRegion(region));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<AddressDTO>> listAddressesByCityName(@PathVariable String city){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.listAddressesByCityName(city));
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<AddressDTO>> listAddressesByStateName(@PathVariable String state){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.listAddressesByStateName(state));
    }

    @GetMapping("/uf/{uf}")
    public ResponseEntity<List<AddressDTO>> listAddressesByUf(@PathVariable String uf){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.listAddressesByUf(uf));
    }
}