import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer implements Runnable {

    public static final int TIME_OUT = 2;



    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));

            try {
                Thread.sleep(TIME_OUT *1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
