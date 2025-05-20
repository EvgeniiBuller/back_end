package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.dto.TaskRequestDto;import de.ait.tasks.dto.TaskResponseDto;import de.ait.tasks.mappers.ProgrammerMapper;
import de.ait.tasks.mappers.TaskMapper;import de.ait.tasks.model.Programmer;import de.ait.tasks.model.Task;
import de.ait.tasks.repository.ProgrammerRepository;
import de.ait.tasks.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;import java.util.List;import java.util.Set;

@Service
@AllArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammer() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return mapper.toResponseDto(repository.findById(id).orElse(null));
    }

    @Override
    public ProgrammerResponseDto createProgrammer(ProgrammerRequestDto programmerRequestDto) {
        Programmer programmer = mapper.fromRequestDto(programmerRequestDto);
        Programmer saved = repository.save(programmer);
        return mapper.toResponseDto(saved);
    }

    @Transactional
    @Override
    public ProgrammerResponseDto assignTask(Long programmerId, Long taskId) {
        Task task = taskRepository.findById(taskId).get();
        Programmer programmer = repository.findById(programmerId).get();
        programmer.addTask(task);
        task.setProgrammer(programmer);
        return mapper.toResponseDto(programmer);
    }

    @Override
    public List<TaskResponseDto> getTasks(Long programmerId) {
        return taskMapper.toResponseDtoList(new ArrayList<>(repository.findById(programmerId).get().getTasks()));
    }
}
