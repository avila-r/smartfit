package com.avila.smartfit.repository;
import com.avila.smartfit.model.Schedule;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;

@SuppressWarnings("unused")
public interface ScheduleRepository extends ListCrudRepository<Schedule, Long> {
    Optional<Schedule> findByLocationId(Long locationId);
    boolean existsByLocationId(Long locationId);
}