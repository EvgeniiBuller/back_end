package de.ait.hm18.service;



import de.ait.hm18.dto.TaskRequestDto;
import de.ait.hm18.dto.TaskResponseDto;
import de.ait.hm18.mappers.TaskMapper;
import de.ait.hm18.model.Task;
import de.ait.hm18.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;
    private final TaskMapper mapper;



    @Override
    // return или значение TaskResponseDto или null
    public List<TaskResponseDto> getTasks() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public TaskResponseDto save (TaskRequestDto taskDto) {
        Task task = mapper.fromDto(taskDto);
        Task saved = repository.save(task);
        return mapper.toDto(saved);
    }

    @Override
    public TaskResponseDto deleteTask(Long id) {
        return mapper.toDto(repository.delete(id));
    }

}
