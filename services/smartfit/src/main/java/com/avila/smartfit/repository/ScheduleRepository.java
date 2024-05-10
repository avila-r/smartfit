package com.avila.smartfit.repository;
import com.avila.smartfit.model.Schedule;
import com.avila.smartfit.model.Unit;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

@SuppressWarnings("unused")
public interface ScheduleRepository extends ListCrudRepository<Schedule, Long> {
    List<Schedule> findByUnitId(Unit unitId);
    boolean existsByUnitId(Unit unitId);
}