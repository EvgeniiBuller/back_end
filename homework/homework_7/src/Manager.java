import java.util.concurrent.BlockingQueue;

class Manager implements Runnable {
    private BlockingQueue<Task> taskQueue;

    public Manager(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Task task = new Task("Task " + i);
                taskQueue.put(task); // Блокируется, если очередь полна
                System.out.println("Manager add task: " + task.getName());
                Thread.sleep((long) (Math.random() * 500));
            }
            // Добавляем специальную задачу-маркер для остановки работников
            taskQueue.put(new Task("Stop"));
            taskQueue.put(new Task("Stop")); // Для всех работников
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}