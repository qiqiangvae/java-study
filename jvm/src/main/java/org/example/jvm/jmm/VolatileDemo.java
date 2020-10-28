package org.example.jvm.jmm;

import java.util.concurrent.*;

/**
 * @author qiqiang
 * @date 2020-10-16 11:41 上午
 */
public class VolatileDemo {
    private static volatile int count = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    increase();
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println(count);
    }

    public static void increase() {
        count++;
    }
}