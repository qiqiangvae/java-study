package org.example.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qiqiang
 * @date 2020-10-26 3:39 下午
 */
public class ReentrantLockExample {
    static int number = 0;
    static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    print();
                }
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    private static void print() {
        lock.lock();
        try {
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
        } finally {
            lock.unlock();
        }
    }
}