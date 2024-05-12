package com.avila.smartfit.service;
import com.avila.smartfit.dto.ScheduleDTO;
import com.avila.smartfit.dto.UnitDTO;
import com.avila.smartfit.exception.unit.UnitNotFoundException;
import com.avila.smartfit.model.Schedule;
import com.avila.smartfit.model.Unit;
import com.avila.smartfit.repository.ScheduleRepository;
import com.avila.smartfit.repository.UnitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public UnitDTO saveUnit(@NotNull UnitDTO unitDTO){
        Unit unit = Unit.builder()
                        .id(unitDTO.id())
                        .title(unitDTO.title())
                        .content(unitDTO.content())
                        .isOpened(unitDTO.opened())
                        .maskStatus(unitDTO.mask())
                        .towelStatus(unitDTO.towel())
                        .fountainStatus(unitDTO.fountain())
                        .lockerRoomStatus(unitDTO.locker_room())
                        .build();
        unitRepository.save(unit);

        List<Schedule> schedules = unitDTO.schedules().stream()
                .map(scheduleDTO ->
                        Schedule.builder()
                                .unitId(unit)
                                .weekdays(scheduleDTO.weekdays())
                                .hour(scheduleDTO.hour())
                                .build()
                )
                .toList();
        scheduleRepository.saveAll(schedules);

        if (unitRepository.existsById(unitDTO.id())) {
            Unit queryUnit = unitRepository.findById(unitDTO.id())
                    .orElseThrow(UnitNotFoundException::new);
            return UnitDTO.builder()
                    .id(queryUnit.getId())
                    .title(queryUnit.getTitle())
                    .content(queryUnit.getContent())
                    .opened(queryUnit.isOpened())
                    .mask(queryUnit.getMaskStatus())
                    .towel(queryUnit.getTowelStatus())
                    .fountain(queryUnit.getFountainStatus())
                    .locker_room(queryUnit.getLockerRoomStatus())
                    .schedules(scheduleRepository.findByUnitId(queryUnit).stream()
                            .map(schedule -> new ScheduleDTO(schedule.getWeekdays(), schedule.getHour()))
                            .toList()
                    )
                    .build();
        }
        else throw new UnitNotFoundException();
    }
}