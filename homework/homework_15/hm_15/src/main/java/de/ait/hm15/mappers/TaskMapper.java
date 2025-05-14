package de.ait.hm15.mappers;




import de.ait.hm15.dto.TaskResponseDto;
import de.ait.hm15.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDto toResponseDto(Task task);
    List<TaskResponseDto> toResponseDtoList(List<Task> task);
}

