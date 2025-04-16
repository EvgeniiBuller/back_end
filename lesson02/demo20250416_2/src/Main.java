public class Main {
    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println(name);
        long id = Thread.currentThread().getId();
        System.out.println(Thread.currentThread().getId());
        System.out.println(name + " " + id + " START");


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " START анонимный класс");
            }
        };

        Thread[] threads = {
                new MyThread(),
                new MyThread(),
                new Thread(new MyRunnable()),
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + " START LAMBDA");
                }),
                thread1
        };

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        Thread.sleep(500);
        System.out.println(name + " " + id + " FINISH");

    }
}