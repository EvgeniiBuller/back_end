import java.util.Random;

public class ServerSimulator implements Runnable {

    private final String serverName;
    private final LatencyMonitor monitor;
    private final int numberOfRequests;
    private final Random random = new Random();

    public ServerSimulator(String serverName, LatencyMonitor monitor, int numberOfRequests) {
        this.serverName = serverName;
        this.monitor = monitor;
        this.numberOfRequests = numberOfRequests;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfRequests; i++) {

            double randomLatency = random.nextDouble() * Integer.MAX_VALUE;
            monitor.updateLatency(randomLatency);
            try {
                Thread.sleep((long) (random.nextDouble() * 10));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println( serverName + " finish");
    }
}
