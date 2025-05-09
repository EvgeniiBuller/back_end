package de.ait.hm_13.repository;

import de.ait.hm_13.model.Task;

import java.util.HashMap;
import java.util.List;



public class TaskDB implements TaskRepository{
    private static  HashMap<Long, Task> map = new HashMap<>();
    static {
        map.put(1L, new Task(1L, "job", 3));
        map.put(2L, new Task(2L, "next", 5));
        map.put(3L, new Task(3L, "laden", 1));
        map.put(4L, new Task(4L, "abladen", 4));
        map.put(5L, new Task(5L, "sortiren", 2));
        map.put(6L, new Task(6L, "weckseln", 6));

    }

    public Task findById(long id) {
        return map.get(id);
    }

    public List<Task> findAll() {
        return map.values().stream().toList();
    }

    @Override
    public Task save(Task task) {
        map.put(task.getId(), task);
        return task;
    }
}
