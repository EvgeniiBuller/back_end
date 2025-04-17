public class Main {
    public static void main(String[] args) throws InterruptedException {

        FirstThread thread1 = new FirstThread();
        SecondThread thread2 = new SecondThread();


        thread1.start();
        thread2.start();


        Thread.sleep(3000);


        System.out.println("Главный поток проснулся и прерывает другие потоки...");
        thread1.interrupt();
        thread2.interrupt();

        System.out.println("Главный поток завершил работу.");
    }
}