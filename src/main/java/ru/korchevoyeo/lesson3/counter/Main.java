package ru.korchevoyeo.lesson3.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        Lock reentrantLock = new ReentrantLock();
        ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter(reentrantLock);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executorService.submit(threadSafeCounter);
        }
        executorService.shutdown();
    }
}
