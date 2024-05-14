package com.avila.smartfit.service;
import com.avila.smartfit.dto.ScheduleDTO;
import com.avila.smartfit.dto.UnitDTO;
import com.avila.smartfit.exception.unit.UnitNotFoundException;
import com.avila.smartfit.model.Schedule;
import com.avila.smartfit.model.Unit;
import com.avila.smartfit.repository.UnitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @AllArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;
    private final ScheduleService scheduleService;
    public record DeleteResponse(boolean success, Unit removed){}

    private UnitDTO build(@NotNull Unit unit){
        if (!unitRepository.existsById(unit.getId())) throw new UnitNotFoundException();
        else return UnitDTO.builder()
                .id(unit.getId())
                .title(unit.getTitle())
                .content(unit.getContent())
                .opened(unit.isOpened())
                .mask(unit.getMaskStatus())
                .towel(unit.getTowelStatus())
                .fountain(unit.getFountainStatus())
                .locker_room(unit.getLockerRoomStatus())
                .schedules(build(scheduleService.getSchedules(unit)))
                .build();
    }

    private Unit build(@NotNull UnitDTO unitDTO){
        return Unit.builder()
                .id(unitDTO.id())
                .title(unitDTO.title())
                .content(unitDTO.content())
                .isOpened(unitDTO.opened())
                .maskStatus(unitDTO.mask())
                .towelStatus(unitDTO.towel())
                .fountainStatus(unitDTO.fountain())
                .lockerRoomStatus(unitDTO.locker_room())
                .build();
    }

    private List<ScheduleDTO> build(@NotNull List<Schedule> schedules){
        return schedules.stream()
                .map(schedule -> new ScheduleDTO(schedule.getWeekdays(), schedule.getHour()))
                .toList();
    }

    @Transactional public UnitDTO saveUnit(@NotNull UnitDTO unitDTO){
        unitRepository.save(build(unitDTO));
        scheduleService.saveSchedules(build(unitDTO), unitDTO);
        if (unitRepository.existsById(unitDTO.id())) return build(unitRepository.findById(unitDTO.id()).orElseThrow(UnitNotFoundException::new));
        else throw new UnitNotFoundException();
    }

    @Transactional public UnitDTO updateUnit(@NotNull UnitDTO unitDTO){
        if (unitRepository.existsById(unitDTO.id())) return build(unitRepository.save(build(unitDTO)));
        else throw new UnitNotFoundException();
    }

    @Transactional public DeleteResponse deleteUnit(@NotNull UnitDTO unitDTO){
        if (unitRepository.existsById(unitDTO.id())){
            unitRepository.delete(build(unitDTO));
            return new DeleteResponse(true, build(unitDTO));
        }
        else throw new UnitNotFoundException();
    }

    @Transactional public DeleteResponse deleteUnitById(Long id){
        Unit unit = unitRepository.findById(id)
                .orElseThrow(UnitNotFoundException::new);
        unitRepository.deleteById(unit.getId());
        return new DeleteResponse(true, unit);
    }

    public UnitDTO getUnitById(Long id){
        return build(unitRepository.findById(id)
                .orElseThrow(UnitNotFoundException::new)
        );
    }

    public UnitDTO getUnitByTitle(String title){
        return build(unitRepository.findByTitle(title)
                .orElseThrow(UnitNotFoundException::new)
        );
    }

    public List<UnitDTO> listAllUnits(){
        return unitRepository.findAll().stream()
                .map(this::build)
                .toList();
    }

    public List<UnitDTO> listAllOpenedUnits(){
        return unitRepository.findAll().stream()
                .map(this::build)
                .filter(UnitDTO::opened)
                .toList();
    }

    public List<UnitDTO> listAllClosedUnits(){
        return unitRepository.findAll().stream()
                .map(this::build)
                .filter(unitDTO -> !unitDTO.opened())
                .toList();
    }

    public List<UnitDTO> getUnitsByMaskStatus(String status){
        return unitRepository.findAll().stream()
                .map(this::build)
                .filter(unitDTO -> unitDTO.mask().equals(status))
                .toList();
    }

    public List<UnitDTO> getUnitsByTowelStatus(String status){
        return unitRepository.findAll().stream()
                .map(this::build)
                .filter(unitDTO -> unitDTO.towel().equals(status))
                .toList();
    }

    public List<UnitDTO> getUnitsByFountainStatus(String status){
        return unitRepository.findAll().stream()
                .map(this::build)
                .filter(unitDTO -> unitDTO.fountain().equals(status))
                .toList();
    }

    public List<UnitDTO> getUnitsByLockerRoomStatus(String status){
        return unitRepository.findAll().stream()
                .map(this::build)
                .filter(unitDTO -> unitDTO.locker_room().equals(status))
                .toList();
    }
}