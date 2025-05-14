package de.ait.hm15.repository;



import de.ait.hm15.model.Priority;
import de.ait.hm15.model.Programmer;
import de.ait.hm15.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskToProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);

}


