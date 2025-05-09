package de.ait.hm_13.repository;

import de.ait.hm_13.model.Task;

import java.util.List;

public interface TaskRepository {
    public List<Task> findAll();
    public Task findById(long id);
    public Task save(Task task);
}
