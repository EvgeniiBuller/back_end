public class FirstThread extends Thread {


    @Override
    public void run() {
        for (int i = 1; ; i++) {
            if (i % 2 == 0) {
                System.out.println("Поток четных: " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток четных прерван.");
                return;
            }
        }
    }
}


