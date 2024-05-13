package com.avila.smartfit.service;
import com.avila.smartfit.dto.UnitDTO;
import com.avila.smartfit.exception.schedule.SchedulesNotFoundException;
import com.avila.smartfit.model.Schedule;
import com.avila.smartfit.model.Unit;
import com.avila.smartfit.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @AllArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    protected void saveSchedules(@NotNull Unit unit, @NotNull UnitDTO unitDTO){
        scheduleRepository.saveAll(
                unitDTO.schedules().stream()
                        .map(scheduleDTO -> Schedule.builder()
                                .unitId(unit)
                                .weekdays(scheduleDTO.weekdays())
                                .hour(scheduleDTO.hour())
                                .build())
                        .toList()
        );
    }

    protected List<Schedule> getSchedules(@NotNull Unit unit){
        return scheduleRepository.findByUnitId(unit).orElseThrow(() -> new SchedulesNotFoundException(unit));
    }
}