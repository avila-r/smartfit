package com.avila.smartfit.repository;
import com.avila.smartfit.model.Address;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;

@SuppressWarnings("unused")
public interface AddressRepository extends ListCrudRepository<Address, Long> {
    Optional<Address> findByTitle(String title);
    Optional<Address> findByStreet(String street);
    Optional<Address> findByRegion(String region);
    Optional<Address> findByUf(String uf);

    boolean existsByTitle(String title);
    boolean existsByStreet(String street);
    boolean existsByRegion(String region);
    boolean existsByUf(String uf);
}