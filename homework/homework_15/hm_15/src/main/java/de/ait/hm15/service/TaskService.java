package de.ait.hm15.service;

import de.ait.hm15.dto.TaskRequestDto;
import de.ait.hm15.dto.TaskResponseDto;
import de.ait.hm15.model.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
    TaskResponseDto deleteTask(Long id);
}

