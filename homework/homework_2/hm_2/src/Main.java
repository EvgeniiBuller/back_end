public class Main {
    public static void main(String[] args) throws InterruptedException {

        FirstThread thread1 = new FirstThread();
        SecondThread thread2 = new SecondThread();

        thread1.setDaemon(true);
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();


        Thread.sleep(3000);




        System.out.println("Главный поток завершил работу.");
    }
}