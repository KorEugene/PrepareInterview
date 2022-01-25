package ru.korchevoyeo.lesson3.counter;

import java.util.concurrent.locks.Lock;

public class ThreadSafeCounter implements Runnable {
    private static final int LIMIT = 1000;

    private final Lock lock;
    private int counter;

    public ThreadSafeCounter(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (counter < LIMIT) {
            lock.lock();
            increaseCounter();
            lock.unlock();
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " got counter value=" + counter);
        while (counter > 0) {
            lock.lock();
            decreaseCounter();
            lock.unlock();
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " got counter value=" + counter);
    }

    private void increaseCounter() {
        if (counter < LIMIT) {
            System.out.println(Thread.currentThread().getName() + " : " + counter);
            counter++;
        }
    }

    private void decreaseCounter() {
        if (counter > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + counter);
            counter--;
        }
    }
}
