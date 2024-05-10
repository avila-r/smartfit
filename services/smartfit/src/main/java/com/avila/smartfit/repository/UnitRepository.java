package com.avila.smartfit.repository;
import com.avila.smartfit.model.Unit;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UnitRepository extends ListCrudRepository<Unit, Long> {
    Optional<Unit> findByTitle(String title);
    boolean existsByTitle(String title);
}