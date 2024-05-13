package com.avila.smartfit.repository;
import com.avila.smartfit.model.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository @SuppressWarnings("unused")
public interface AddressRepository extends ListCrudRepository<Address, Long> {
    Optional<Address> findByTitle(String title);
    Optional<Address> findByStreet(String street);
    List<Address> findAddressByRegion(String region);
    List<Address> findAddressesByCityName(String cityName);
    List<Address> findAddressesByStateName(String stateName);
    List<Address> findAddressesByUf(String uf);

    boolean existsByTitle(String title);
    boolean existsByStreet(String street);
    boolean existsByRegion(String region);
    boolean existsByUf(String uf);
}