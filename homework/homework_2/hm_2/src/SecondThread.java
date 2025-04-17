public class SecondThread extends Thread {


    @Override
    public void run() {
        for (int i = 1; true ; i++) {
            if (i % 3 == 0) {
                System.out.println("Поток делится на 3: " + i);
            }
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("Поток делится на 3 прерван.");
                return;
            }
        }
    }
}

