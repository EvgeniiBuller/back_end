package de.ait.hm18.controller;

import de.ait.hm18.dto.ProgrammerResponseDto;
import de.ait.hm18.model.Task;
import de.ait.hm18.service.ProgrammerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programmers")

public class ProgrammerController {


    private final ProgrammerService service;


    @GetMapping
    public ResponseEntity<List<ProgrammerResponseDto>> getProgrammers() {
        return ResponseEntity.ok().body(service.getProgrammers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammerResponseDto> getProgrammer(@PathVariable("id") Long id) {
        return ResponseEntity.ofNullable(service.getProgrammerById(id));
    }


    //получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getTaskByProgrammer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findTasksByProgrammerId(id));
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/{programmerId}/tasks/{taskId}")
    public ResponseEntity<Void> addTaskToProgrammer(@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId) {
        ProgrammerService.addTaskToProgrammer(programmerId, taskId);
        return ResponseEntity.noContent().build();
    }
}

