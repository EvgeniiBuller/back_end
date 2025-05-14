package de.ait.hm15.dto;

import de.ait.hm15.model.Priority;
import lombok.*;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "id")

public class TaskResponseDto {
    private long id;
    private String description;
    private Priority priority;
}
