package de.ait.hm18.repository;

import de.ait.hm18.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    Optional<Task> findById(Set<Task> id);
    Task delete(Long id);
    Task save(Task task);



}
