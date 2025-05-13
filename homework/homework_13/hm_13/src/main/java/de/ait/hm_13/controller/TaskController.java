package de.ait.hm_13.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */


import de.ait.hm_13.model.Task;
import de.ait.hm_13.repository.TaskRepository;
import de.ait.hm_13.repository.TaskRepositoryMapImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

//@AllArgsConstructor
@RestController

public class TaskController {

    private final TaskRepository repository;

    private final Scanner scanner;

    public TaskController(@Qualifier("taskRepositoryMapImpl") TaskRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        System.out.println("input");
        String s = scanner.nextLine();
        System.out.println(s);
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long taskid) {
        return repository.findById(taskid);
    }

    @PostMapping("/tasks")
    public Task createNewTask(@RequestBody Task task) {
        System.out.println(task);
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTaskById(@PathVariable("id") long id) {
        return repository.delete(id);
    }
}