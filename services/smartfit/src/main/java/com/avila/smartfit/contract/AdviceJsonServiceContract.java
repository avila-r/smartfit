package com.avila.smartfit.contract;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.dto.ScheduleDTO;
import com.avila.smartfit.dto.UnitDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AdviceJsonServiceContract {
    ResponseEntity<List<UnitDTO>> listUnitDTOs();
    ResponseEntity<List<ScheduleDTO>> getScheduleDTO(UnitDTO unitDTO);
    ResponseEntity<List<AddressDTO>> listAddressDTOs();
}