package de.ait.hm18.service;

import de.ait.hm18.dto.ProgrammerRequestDto;
import de.ait.hm18.dto.ProgrammerResponseDto;
import de.ait.hm18.dto.TaskRequestDto;
import de.ait.hm18.dto.TaskResponseDto;
import de.ait.hm18.model.Programmer;
import de.ait.hm18.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgrammerService  {


    static void addTaskToProgrammer(Long programmerId, Long taskId) {
    }

    List<ProgrammerResponseDto> getProgrammers();

    ProgrammerResponseDto getProgrammerById(Long id);



    ProgrammerResponseDto save (ProgrammerRequestDto dto);

    ProgrammerResponseDto deleteTask(Long id);

    List<Task> findTasksByProgrammerId(Long id);
}

