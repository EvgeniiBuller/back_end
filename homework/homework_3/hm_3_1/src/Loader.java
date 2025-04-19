public class Loader implements Runnable{

    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse;
    private int done = 0;
    private Runnable completionCallback;

    public Loader(String name, int nBox, int capacity, Warehouse warehouse, Runnable completionCallback) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
        this.completionCallback = completionCallback;
    }


    @Override
    public void run() {
        for (int i = 0; i < nBox; i++) {
            warehouse.addValue(capacity);
            System.out.println(name + " загрузил коробку " + (i + 1));
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(name + " завершил загрузку.");
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

