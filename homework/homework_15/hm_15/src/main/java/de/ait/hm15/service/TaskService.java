package de.ait.hm15.service;


import de.ait.hm15.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {

    List<TaskResponseDto> getAllTasks();

}
