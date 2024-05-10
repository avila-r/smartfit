package com.avila.smartfit.service;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.model.Address;
import com.avila.smartfit.repository.AddressRepository;
import com.avila.smartfit.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public AddressDTO saveAddress(@NotNull AddressDTO addressDTO){
        Address address = Address.builder()
                .id(addressDTO.id())
                .title(addressDTO.title())
                .street(addressDTO.street())
                .region(addressDTO.region())
                .cityName(addressDTO.city_name())
                .stateName(addressDTO.state_name())
                .uf(addressDTO.uf())
                .build();
        addressRepository.save(address);

        if (addressRepository.existsById(addressDTO.id())) {
            Address queryAddress = addressRepository.findById(addressDTO.id())
                    .orElseThrow(); // TODO: Custom exception
            return AddressDTO.builder()
                    .id(queryAddress.getId())
                    .title(queryAddress.getTitle())
                    .street(queryAddress.getStreet())
                    .region(queryAddress.getRegion())
                    .city_name(queryAddress.getCityName())
                    .state_name(queryAddress.getStateName())
                    .uf(queryAddress.getUf())
                    .build();
        }
        else throw new RuntimeException(); // TODO: Custom exception
    }
}