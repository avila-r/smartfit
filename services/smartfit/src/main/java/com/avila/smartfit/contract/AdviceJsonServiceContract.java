package com.avila.smartfit.contract;
import com.avila.smartfit.dto.AddressDTO;
import com.avila.smartfit.dto.ScheduleDTO;
import com.avila.smartfit.dto.UnitDTO;
import java.util.List;

public interface AdviceJsonServiceContract {
    List<UnitDTO> listUnitDTOs();
    List<ScheduleDTO> getScheduleDTO(UnitDTO unitDTO);
    List<AddressDTO> listAddressDTOs();
}