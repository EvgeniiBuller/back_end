package de.ait.hm_13.repository;

import org.springframework.stereotype.Repository;
import de.ait.hm_13.model.Priority;
import de.ait.hm_13.model.Programmer;
import de.ait.hm_13.model.Task;

import java.util.List;


public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskToProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);

}

