package com.avila.smartfit.repository;
import com.avila.smartfit.model.Schedule;
import com.avila.smartfit.model.Unit;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository @SuppressWarnings("unused")
public interface ScheduleRepository extends ListCrudRepository<Schedule, Long> {
    Optional<List<Schedule>> findByUnitId(Unit unitId);
    boolean existsByUnitId(Unit unitId);
}