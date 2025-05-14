package de.ait.hm15.dto;

import de.ait.hm15.model.Priority;
import lombok.*;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString


public class TaskRequestDto {

    private String description;
    private Priority priority;
}
