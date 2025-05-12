package de.ait.hm_13.model;

import lombok.*;

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
