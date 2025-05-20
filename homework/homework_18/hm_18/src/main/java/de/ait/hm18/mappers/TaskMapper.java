package de.ait.hm18.mappers;

import de.ait.hm18.dto.TaskRequestDto;
import de.ait.hm18.dto.TaskResponseDto;
import de.ait.hm18.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task fromDto(TaskRequestDto dto);
    TaskResponseDto toDto(Task task);
    List<TaskResponseDto> toDtoList (List<Task> task);

}


