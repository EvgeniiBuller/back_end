public class Main {

    public static void main(String[] args) throws InterruptedException {
        int numberOfServers = 3;
        int requestsPerServer = 100;
        LatencyMonitor monitor = new LatencyMonitor();

        Thread[] servers = new Thread[numberOfServers];
        for (int i = 0; i < numberOfServers; i++) {
            servers[i] = new Thread(new ServerSimulator("Server-" + (i + 1), monitor, requestsPerServer));
            servers[i].start();
        }

        for (Thread server : servers) {
            server.join();
        }

        System.out.println("Минимальная зафиксированная задержка: " + monitor.getMinLatency() + " мс");
    }
}