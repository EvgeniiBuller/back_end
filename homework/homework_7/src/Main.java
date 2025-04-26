import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        int queueCapacity = 5;
        BlockingQueue<Task> taskQueue = new ArrayBlockingQueue<>(queueCapacity);

        Thread manager = new Thread(new Manager(taskQueue));
        Thread worker1 = new Thread(new Worker("Worker-1", taskQueue));
        Thread worker2 = new Thread(new Worker("Worker-2", taskQueue));

        manager.start();
        worker1.start();
        worker2.start();

        manager.join();
        worker1.join();
        worker2.join();

        System.out.println("Finish");
    }
}