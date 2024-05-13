package com.avila.smartfit.service;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.exception.address.AddressNotFoundException;
import com.avila.smartfit.model.Address;
import com.avila.smartfit.repository.AddressRepository;
import com.avila.smartfit.repository.UnitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final UnitRepository unitRepository;

    public record DeleteResponse(boolean success, Address removed){}

    private AddressDTO build(@NotNull Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .title(address.getTitle())
                .street(address.getStreet())
                .region(address.getRegion())
                .city_name(address.getCityName())
                .state_name(address.getStateName())
                .uf(address.getUf())
                .build();
    }

    private Address build(@NotNull AddressDTO addressDTO){
        return Address.builder()
                .id(addressDTO.id())
                .title(addressDTO.title())
                .street(addressDTO.street())
                .region(addressDTO.region())
                .cityName(addressDTO.city_name())
                .stateName(addressDTO.state_name())
                .uf(addressDTO.uf())
                .build();
    }

    @Transactional public AddressDTO saveAddress(@NotNull AddressDTO addressDTO){
        addressRepository.save(build(addressDTO));
        if (addressRepository.existsById(addressDTO.id())) return build(addressRepository.findById(addressDTO.id()).orElseThrow(AddressNotFoundException::new));
        else throw new AddressNotFoundException();
    }

    @Transactional public AddressDTO updateAddress(@NotNull AddressDTO addressDTO){
        if (addressRepository.existsById(addressDTO.id())) return build(addressRepository.save(build(addressDTO)));
        else throw new AddressNotFoundException();
    }

    @Transactional public DeleteResponse deleteAddress(@NotNull AddressDTO addressDTO){
        if (addressRepository.existsById(addressDTO.id())){
            addressRepository.delete(build(addressDTO));
            return new DeleteResponse(true, build(addressDTO));
        }
        else throw new AddressNotFoundException();
    }

    @Transactional public DeleteResponse deleteAddressById(Long id){
        Address address = addressRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new);
        addressRepository.deleteById(address.getId());
        return new DeleteResponse(true, address);
    }

    public AddressDTO getAddressById(Long id){
        return build(addressRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new)
        );
    }

    public AddressDTO getAddressByTitle(String title){
        return build(addressRepository.findByTitle(title)
                .orElseThrow(AddressNotFoundException::new)
        );
    }

    public AddressDTO getAddressByStreet(String street){
        return build(addressRepository.findByStreet(street)
                .orElseThrow(AddressNotFoundException::new)
        );
    }

    public List<AddressDTO> listAllAddresses(){
        return addressRepository.findAll().stream()
                .map(this::build)
                .toList();
    }

    public List<AddressDTO> listAddressesByRegion(String region){
        return addressRepository.findAddressByRegion(region).stream()
                .map(this::build)
                .toList();
    }

    public List<AddressDTO> listAddressesByCityName(String city){
        return addressRepository.findAddressesByCityName(city).stream()
                .map(this::build)
                .toList();
    }

    public List<AddressDTO> listAddressesByStateName(String state){
        return addressRepository.findAddressesByStateName(state).stream()
                .map(this::build)
                .toList();
    }

    public List<AddressDTO> listAddressesByUf(String uf){
        return addressRepository.findAddressesByUf(uf).stream()
                .map(this::build)
                .toList();
    }
}