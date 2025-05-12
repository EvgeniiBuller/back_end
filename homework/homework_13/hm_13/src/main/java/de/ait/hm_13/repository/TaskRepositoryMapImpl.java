package de.ait.hm_13.repository;

import de.ait.hm_13.model.Priority;
import de.ait.hm_13.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@AllArgsConstructor

public class TaskRepositoryMapImpl implements TaskRepository{
    private static  HashMap<Long, Task> map = new HashMap<>();
    private static Long lastId = 5L;
    static {
        map.put(1L, new Task(1L, "job", Priority.LOW));
        map.put(2L, new Task(2L, "next",Priority.HIGH));
        map.put(3L, new Task(3L, "laden", Priority.LOW));
        map.put(4L, new Task(4L, "abladen", Priority.MIDDLE));
        map.put(5L, new Task(5L, "sortiren", Priority.LOW));
    }
    @Override
    public List<Task> findAll() {
        return map.values().stream().toList();
    }
    @Override
    public Task findById(long id) {
        if(id<1 || id>lastId){
            throw  new RuntimeException("id is not valid");//IdNotFoundException
        }
        return map.get(id);
    }

    @Override
    public Task save(Task task) {
        task.setId(++lastId);
        map.put(lastId, task);
        return task;
    }

    @Override
    public Task delete(long id) {
        return map.remove(id);
    }
}
