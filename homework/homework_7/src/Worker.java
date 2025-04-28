import java.util.concurrent.BlockingQueue;

class Worker implements Runnable {
    private BlockingQueue<Task> taskQueue;
    private String name;

    public Worker(String name, BlockingQueue<Task> taskQueue) {
        this.name = name;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = taskQueue.take(); // Блокируется, если очередь пуста
                if (task.getName().equals("Stop")) {
                    System.out.println("Worker " + name + " finish");
                    break;
                }
                System.out.println("Worker " + name + " received task: " + task.getName());
                task.execute();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}