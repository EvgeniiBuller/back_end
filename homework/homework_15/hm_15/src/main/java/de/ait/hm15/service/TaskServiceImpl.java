package de.ait.hm15.service;

import de.ait.hm15.dto.TaskResponseDto;
import de.ait.hm15.mappers.TaskMapper;
import de.ait.hm15.model.Task;
import de.ait.hm15.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;
    private final TaskMapper mapper;


/*
    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<Task> taskList = repository.findAll();
        return taskList.stream()
                .map(TaskServiceImpl::getTaskResponseDto)
                .toList();
    }
*/

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    /*
    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<Task> taskList = repository.findAll();
        return taskList.stream()
                .map(t->mapper.toResponseDto(t))
                .toList();
    }
*/


    private static TaskResponseDto getTaskResponseDto(Task t) {
        return new TaskResponseDto(t.getId(), t.getDescription(), t.getPriority());
    }
}
