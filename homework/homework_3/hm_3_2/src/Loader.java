public class Loader implements Runnable {
    private String name;
    private int nBox;
    private int capacity; // Количество коробок, которые грузчик отвозит на один склад за раз
    private Warehouse warehouse1;
    private Warehouse warehouse2;
    private Runnable completionCallback;

    public Loader(String name, int nBox, int capacity, Warehouse warehouse1, Warehouse warehouse2, Runnable completionCallback) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse1 = warehouse1;
        this.warehouse2 = warehouse2;
        this.completionCallback = completionCallback;
    }

    @Override
    public void run() {

        for (int i = 0; i < nBox; i++) {
            warehouse1.addValue(capacity);
            System.out.println(name + " отвез коробку на склад 1 " + warehouse1.getClass() + " (коробка " + (i + 1) + ")");
            warehouse2.addValue(capacity);
            System.out.println(name + " отвез коробку на склад 2 " + warehouse2.getClass() + " (коробка " + (i + 1) + ")");
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(name + " завершил работу.");
        if (completionCallback != null) {
            completionCallback.run();
        }
    }

    @Override
    public String toString() {
        return "Loader{" +
                "name='" + name + '\'' +
                '}';
    }
}