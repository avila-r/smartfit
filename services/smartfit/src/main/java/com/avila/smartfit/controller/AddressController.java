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

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressByPathVariableId(@PathVariable Long id){
        return null;
    }

    @GetMapping
    public ResponseEntity<AddressDTO> getAddressByRequestParamId(
            @RequestParam(name = "id") Long id
    ){
        if (id != null) return null; else throw new RuntimeException(); // TODO: Custom exception
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<AddressDTO> getAddressByTitle(@PathVariable String title){
        return null;
    }

    @GetMapping("/street/{street}")
    public ResponseEntity<AddressDTO> getAddressByStreet(@PathVariable String street){
        return null;
    }

    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(AddressDTO request){
        return null;
    }

    @PutMapping
    public ResponseEntity<AddressDTO> updateAddress(AddressDTO request){
        return null;
    }

    @DeleteMapping
    public void deleteAddress(AddressDTO request){

    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable Long id){

    }

    @GetMapping("/list")
    public List<ResponseEntity<AddressDTO>> listAllAddresses(){
        return null;
    }

    @GetMapping("/region/{region}")
    public List<ResponseEntity<AddressDTO>> listAddressesByRegion(@PathVariable String region){
        return null;
    }

    @GetMapping("/city/{city}")
    public List<ResponseEntity<AddressDTO>> listAddressesByCityName(@PathVariable String city){
        return null;
    }

    @GetMapping("/state/{state}")
    public List<ResponseEntity<AddressDTO>> listAddressesByStateName(@PathVariable String state){
        return null;
    }

    @GetMapping("/uf/{uf}")
    public List<ResponseEntity<AddressDTO>> listAddressesByUf(@PathVariable String uf){
        return null;
    }
}