import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111", "Jack", 1000);
        Account accountB = new Account("DE2222", "John", 1000);

        System.out.println("Состояние счета Jack : " + accountA);
        System.out.println("Состояние счета John : " + accountB);
        System.out.println();

        Thread thread1 = new Thread(
                () -> {
                    lock.lock();
                    try {
                        System.out.println("thread1 делает перевод");
                        transfer(accountA, accountB, 100);
                        System.out.println("thread1 завершил перевод");
                        try {
                            Thread.sleep(100);
                            System.out.println("Состояние счета Jack после переводов: " + accountA);
                            System.out.println("Состояние счета John после переводов: " + accountB);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } finally {
                        lock.unlock();
                        System.out.println("tread-1 frei");
                        System.out.println();
                    }
                }, "T-1");


        Thread thread2 = new Thread(
                () -> {
                    try {
                        lock.lockInterruptibly();
                        try {
                            System.out.println("thread2 делает перевод");
                            transfer(accountB, accountA, 500);
                            System.out.println("thread2 завершил перевод");
                            try {
                                Thread.sleep(100);
                                System.out.println("Состояние счета Jack после переводов: " + accountA);
                                System.out.println("Состояние счета John после переводов: " + accountB);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } finally {
                            lock.unlock();
                            System.out.println("tread-2 frei");
                        }
                    } catch (InterruptedException e) {
                        System.out.println("thread-2: прерван во время ожидания блокировки");
                    }
                }, "T-2");

        //Scanner scanner = new Scanner(System.in);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        //System.out.println("Нажмите Enter если устали ждать");
        //scanner.nextLine();
        //thread2.interrupt();
        System.out.println();
        System.out.println("Состояние счета Jack после переводов: " + accountA);
        System.out.println("Состояние счета John после переводов: " + accountB);
    }

    public static void transfer(Account from, Account to, double amount) {
        Account first = from.hashCode() < to.hashCode() ? from : to;
        Account second = from.hashCode() < to.hashCode() ? to : from;

        synchronized (first) {
            System.out.println("account " + from + " is locked by " + Thread.currentThread().getName());

            synchronized (second) {
                System.out.println("account " + to + " is locked by" + Thread.currentThread().getName());
                if (from.withdraw(amount)) {
                    to.deposit(amount);

                }
            }
        }
    }
}