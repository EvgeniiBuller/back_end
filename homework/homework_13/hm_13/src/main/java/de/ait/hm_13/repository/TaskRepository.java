package de.ait.hm_13.repository;

import de.ait.hm_13.model.Task;

import java.util.List;

public interface TaskRepository {
     List<Task> findAll();
     Task findById(long id);
     Task delete(long id);
     Task save(Task task);
}
