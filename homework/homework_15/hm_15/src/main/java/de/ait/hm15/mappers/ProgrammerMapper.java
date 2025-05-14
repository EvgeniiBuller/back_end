package de.ait.hm15.mappers;


import de.ait.hm15.dto.ProgrammerResponseDto;
import de.ait.hm15.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toResponseDto(Programmer programmer);
    List<ProgrammerResponseDto> toResponseDtoList(List<Programmer> programmers);
}
