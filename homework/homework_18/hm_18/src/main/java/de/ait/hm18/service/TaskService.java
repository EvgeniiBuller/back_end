package de.ait.hm18.service;

import de.ait.hm18.dto.TaskRequestDto;
import de.ait.hm18.dto.TaskResponseDto;
import de.ait.hm18.model.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto save (TaskRequestDto dto);
    TaskResponseDto deleteTask(Long id);
}

