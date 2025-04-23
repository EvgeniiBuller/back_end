public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111", "Jack", 1000);
        Account accountB = new Account("DE2222", "John", 1000);

        Thread thread1 = new Thread(() -> {
            try {
                accountA.withdraw(100);
                accountB.deposit(100);
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка в потоке T1: " + e.getMessage());
            }
        }, "T1");



        Thread thread2 = new Thread(() -> {
            try {
                accountB.withdraw(500);
                accountA.deposit(500);
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка в потоке T2: " + e.getMessage());
            }
        }, "T2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);

    }
}