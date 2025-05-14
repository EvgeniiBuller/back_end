package de.ait.hm15.model;

import lombok.*;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of="id")


public class Task {
    @Setter
    private Long id;
    private String description;
    private Priority priority;



}
