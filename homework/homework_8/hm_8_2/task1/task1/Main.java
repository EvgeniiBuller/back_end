package task1;

public class Main {
    private final static int N_TASKS=20;
    private final static int N_WORKERS=5;


    public static void main(String[] args) throws InterruptedException {
        TaskBoard taskBoard = new TaskBoardImpl2();

        Thread manager = new Thread(new task1.Manager(taskBoard, N_TASKS));

        Thread[] threads = new Thread[N_WORKERS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker(taskBoard,"jack-"+i)   );
            threads[i].setDaemon(true);
            threads[i].start();
        }

        manager.start();
        Thread.sleep(1000);
        manager.join();

    }
}
