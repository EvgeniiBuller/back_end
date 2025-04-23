import java.util.concurrent.atomic.AtomicLong;

public class LatencyMonitor {

    private final AtomicLong minLatency = new AtomicLong(Long.MAX_VALUE);

    public void updateLatency(double latency) {
        long latencyLong = (long) latency;
        minLatency.updateAndGet(currentMin -> Math.min(currentMin, latencyLong));
    }

    public long getMinLatency() {
        return minLatency.get();
    }
}