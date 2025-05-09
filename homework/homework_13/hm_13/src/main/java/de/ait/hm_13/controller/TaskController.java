package de.ait.hm_13.controller;

import de.ait.hm_13.model.Task;
import de.ait.hm_13.repository.TaskDB;
import de.ait.hm_13.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TaskController {
    TaskRepository repository = new TaskDB();

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @GetMapping("/tasks{id}")
    public Task getById(@PathVariable(name = "id") Long taskid) {
        return repository.findById(taskid);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

}