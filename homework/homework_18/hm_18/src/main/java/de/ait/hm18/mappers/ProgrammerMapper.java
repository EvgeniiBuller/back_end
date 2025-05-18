package de.ait.hm18.mappers;

import de.ait.hm18.dto.ProgrammerRequestDto;
import de.ait.hm18.dto.ProgrammerResponseDto;
import de.ait.hm18.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    List<ProgrammerResponseDto> toDtoList(List<Programmer> programmer);
    Programmer fromDto(ProgrammerRequestDto dto);
    ProgrammerResponseDto toDto(Optional<Programmer> programmer);


}

