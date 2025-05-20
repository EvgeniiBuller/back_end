package de.ait.tasks.repository;

import de.ait.tasks.model.Priority;
import de.ait.tasks.model.Programmer;
import de.ait.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ProgrammerRepository extends JpaRepository<Programmer,Long> {
    List<Programmer> findAll();
    Optional<Programmer> findById(Long id);
    Programmer save(Programmer programmer);



}
