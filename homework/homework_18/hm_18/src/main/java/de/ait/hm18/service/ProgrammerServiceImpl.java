package de.ait.hm18.service;


import de.ait.hm18.dto.ProgrammerRequestDto;
import de.ait.hm18.dto.ProgrammerResponseDto;
import de.ait.hm18.mappers.ProgrammerMapper;
import de.ait.hm18.mappers.TaskMapper;
import de.ait.hm18.model.Programmer;
import de.ait.hm18.model.Task;
import de.ait.hm18.repository.ProgrammerRepository;
import de.ait.hm18.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;
    private final TaskRepository taskRepository;

    @Override
    public List<ProgrammerResponseDto> getProgrammers() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return mapper.toDto(repository.findById(id));
    }

    @Override
    public ProgrammerResponseDto save (ProgrammerRequestDto dto) {
        Programmer programmer = mapper.fromDto(dto);
        Task task = taskRepository.findById(dto.getTasks()).orElseThrow(()-> new RuntimeException("Task not found"));
        programmer.setTask(task);
        Programmer saved = repository.save(programmer);
        return mapper.toDto(Optional.of(saved));
    }

    @Override
    public ProgrammerResponseDto deleteTask(Long id) {
        return mapper.toDto(repository.deleteTaskToProgrammer(id));
    }

    @Override
    public List<Task> findTasksByProgrammerId(Long id) {
        return List.of();
    }
}

