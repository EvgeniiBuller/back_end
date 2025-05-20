package de.ait.hm18.dto;

import de.ait.hm18.model.Priority;
import lombok.*;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
//@EqualsAndHashCode(of = "id")

public class TaskResponseDto {
    private long id;
    private String description;
    private Priority priority;
}
