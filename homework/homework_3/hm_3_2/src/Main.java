public class Main {
    private static final int N_BOX = 1000;
    private static final int CAPACITY = 1;

    private static volatile String firstNameOfCompletedLoader = null;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Warehouse warehouse1 = new Warehouse("#1");
        Warehouse warehouse2 = new Warehouse("#2");

        Loader jackLoader = new Loader("Jack", N_BOX, CAPACITY, warehouse1, warehouse2, () -> markAsCompleted("Jack"));
        Loader johnLoader = new Loader("John", N_BOX, CAPACITY, warehouse1, warehouse2, () -> markAsCompleted("John"));
        Loader NickLoader = new Loader("Nick", N_BOX, CAPACITY, warehouse1, warehouse2, () -> markAsCompleted("Nick"));

        Thread[] loaders = {
                new Thread(jackLoader),
                new Thread(johnLoader),
                new Thread(NickLoader)
        };

        for (Thread thread : loaders) {
            thread.start();
        }

        for (Thread thread : loaders) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println(warehouse1);
        System.out.println(warehouse2);

        if (firstNameOfCompletedLoader != null) {
            System.out.println("Первым завершил : " + firstNameOfCompletedLoader);

        } else {
            System.out.println("Все грузчики завершились одновременно или возникла проблема с определением первого.");
        }
    }

    private static void markAsCompleted(String loaderName) {
        synchronized (lock) {
            if (firstNameOfCompletedLoader == null) {
                firstNameOfCompletedLoader = loaderName;
            }
        }
    }
}