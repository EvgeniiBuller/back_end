public class Main {
    public static void main(String[] args) throws InterruptedException {
        Document documentA = new Document(4322, "text1");
        Document documentB = new Document(2243, "text1");

        Thread thread1 = new Thread(() -> edit(documentA, documentB), "T1");
        Thread thread2 = new Thread(() -> edit(documentB, documentA), "T2");
        Thread lockMonitor = new DeadlockDetector();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(documentA);
        System.out.println(documentB);
    }

    public static void edit(Document from, Document to) {
        Document first = from.getId() < to.getId() ? from : to;
        Document second = from.getId() < to.getId() ? to : from;
    }

}