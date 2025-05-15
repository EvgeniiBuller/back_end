package de.ait.hm15.mappers;

import de.ait.hm15.dto.ProgrammerRequestDto;
import de.ait.hm15.dto.ProgrammerResponseDto;
import de.ait.hm15.dto.TaskRequestDto;
import de.ait.hm15.dto.TaskResponseDto;
import de.ait.hm15.model.Programmer;
import de.ait.hm15.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toResponseDto(Programmer task);
    List<ProgrammerResponseDto> toResponseDtoList(List<Programmer> programmer);
    Programmer fromRequestDto(ProgrammerRequestDto dto);
}

