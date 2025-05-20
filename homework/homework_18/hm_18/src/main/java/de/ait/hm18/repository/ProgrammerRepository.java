package de.ait.hm18.repository;



import de.ait.hm18.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
    List<Programmer> findAll();
    Optional<Programmer> findById(Long id);
    Programmer save(Programmer programmer);
    List<Programmer> findByTasksStartingWithOrderById(Long id);
//    void addTaskToProgrammer(Long programmerId, Long taskId);
    Optional<Programmer> deleteTaskToProgrammer(Long programmerId);


}


