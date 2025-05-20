package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getAllProgrammer();
    ProgrammerResponseDto getProgrammerById(Long id);
    ProgrammerResponseDto createProgrammer(ProgrammerRequestDto programmerRequestDto);
    ProgrammerResponseDto assignTask(Long programmerId, Long taskId);
    List<TaskResponseDto> getTasks(Long programmerId);

}
