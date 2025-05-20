package de.ait.tasks.controller;

import de.ait.tasks.dto.ProgrammerRequestDto;import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.dto.TaskResponseDto;import de.ait.tasks.model.Programmer;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.ProgrammerRepository;
import de.ait.tasks.service.ProgrammerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
public class ProgrammerController {

    private final ProgrammerRepository repository;
    private final ProgrammerService service;



    @GetMapping("/programmers")
    public ResponseEntity<List<ProgrammerResponseDto>> getProgrammers(){
        return ResponseEntity.ok(service.getAllProgrammer());
    }

    @PostMapping("/programmers")
    public ResponseEntity<ProgrammerResponseDto> createProgrammers(@RequestBody ProgrammerRequestDto dto){
        return ResponseEntity.ok(service.createProgrammer(dto));
    }

    @GetMapping("/programmers/{id}")
    public ResponseEntity<ProgrammerResponseDto> getProgrammerById(@PathVariable("id") Long id){
        return ResponseEntity.ofNullable(service.getProgrammerById(id));
    }


    //получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTaskByProgrammer(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getTasks(id));
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public void addTaskToProgrammer(@PathVariable("programmerId") Long programmerID, @PathVariable("taskId") Long taskId){
       service.assignTask(programmerID,taskId);
    }

}
