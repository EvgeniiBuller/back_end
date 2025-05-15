package de.ait.hm15.service;

import de.ait.hm15.dto.ProgrammerRequestDto;
import de.ait.hm15.dto.ProgrammerResponseDto;
import de.ait.hm15.dto.TaskRequestDto;
import de.ait.hm15.dto.TaskResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getAllProgrammer();
    ProgrammerResponseDto getProgrammerById(Long id);
    ProgrammerResponseDto createTask(ProgrammerRequestDto taskRequestDto);
    ProgrammerResponseDto deleteTask(Long id);

}

