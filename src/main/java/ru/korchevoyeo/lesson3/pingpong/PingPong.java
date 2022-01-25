package ru.korchevoyeo.lesson3.pingpong;

public class PingPong {
    private static final String PING = "ping";
    private static final String PONG = "pong";

    private final Object monitor = new Object();
    private String action = PING;
    private final int maxHits = 5;

    public static void main(String[] args) {
        PingPong multiThreading = new PingPong();

        new Thread(multiThreading::printPing).start();
        new Thread(multiThreading::printPong).start();
    }

    private void printPing() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < maxHits; i++) {
                    while (!action.equals(PING)) {
                        monitor.wait();
                    }
                    System.out.println(action);
                    action = PONG;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printPong() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < maxHits; i++) {
                    while (!action.equals(PONG)) {
                        monitor.wait();
                    }
                    System.out.println(action);
                    action = PING;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
