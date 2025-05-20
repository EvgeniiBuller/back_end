package de.ait.hm18.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */

import de.ait.hm18.dto.TaskRequestDto;
import de.ait.hm18.dto.TaskResponseDto;
import de.ait.hm18.repository.TaskRepository;
import de.ait.hm18.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

//@AllArgsConstructor
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;
    private final TaskRepository repository; // repository temporary

//    private Scanner scanner;
//
//    @Autowired
//    public void setScanner(Scanner scanner) {
//        this.scanner = scanner;
//    }


    public TaskController(@Qualifier("taskRepositoryMapImpl") TaskRepository repository, TaskService service) {
        this.repository = repository;
        this.service = service;

    }


    @GetMapping
    public ResponseEntity< List<TaskResponseDto> > getTasks(){
        return ResponseEntity.ok(service.getTasks());
    }

    // если ok то 200OK и TaskResponseDto   иначе  404NotFound
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long taskId){
        TaskResponseDto taskById = service.getTaskById(taskId);
        //return (taskById!=null)? ResponseEntity.ok(taskById) : ResponseEntity.notFound().build();

        return ResponseEntity.ofNullable(taskById);
    }


    @PostMapping
    public ResponseEntity<TaskResponseDto> createNewTask(@RequestBody TaskRequestDto task){
        TaskResponseDto savedTask = service.save(task);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedTask);
/*
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                //.header("location", location.toString())
                .body(savedTask);
*/

    }

    /*
    A successful response SHOULD be 200 (OK) if the response includes an entity
    describing the status, 202 (Accepted) if the action has not yet been enacted,
    or 204 (No Content) if the action has been enacted but the response
    does not include an entity.
     */

    @DeleteMapping("/{id}")
    public  ResponseEntity<TaskResponseDto> deleteTaskById(@PathVariable("id") Long id){
        TaskResponseDto deletedTask = service.deleteTask(id);
        return ResponseEntity.ofNullable(deletedTask);
    }
}
