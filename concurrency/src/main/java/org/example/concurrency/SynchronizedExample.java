package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qiqiang
 * @date 2020-10-26 4:45 下午
 */
public class SynchronizedExample {
    static int number = 0;
    static final Object LOCK = new Object();


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
        synchronized (LOCK) {
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
        }
    }
}