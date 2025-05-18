package de.ait.hm18.dto;



import de.ait.hm18.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProgrammerRequestDto {
    private String name;
    private Set<Task> tasks = new HashSet<>();
}

