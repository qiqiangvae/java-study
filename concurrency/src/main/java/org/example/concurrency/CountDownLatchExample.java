package org.example.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qiqiang
 * @date 2020-10-26 5:20 下午
 */
public class CountDownLatchExample {
    static final int COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < COUNT; i++) {
            int number = i;
            executorService.execute(() -> {
                System.out.println("选手" + number + "准备好了!");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("所有选手准备完毕，跑");
    }
}