package org.example.arithmetic.tokenbucket;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 令牌桶思想：
 * 每秒产生固定的令牌到桶里，桶有容量限制，每次从桶里取出一个令牌使用
 *
 * @author qiqiang
 * @date 2020-10-30 10:25 上午
 */
public class JavaThreadTokenBucketExample {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket();
        Thread.sleep(1000);
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2);
        executorService.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + "获取令牌" + (tokenBucket.get(1) ? "成功" : "获取令牌失败"));

        }, 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + "获取令牌" + (tokenBucket.get(1) ? "成功" : "获取令牌失败"));

        }, 0, 1, TimeUnit.SECONDS);
    }

    static class TokenBucket {
        /**
         * 令牌桶容量为100
         */
        private final static long CAPACITY = 100;
        /**
         * 1s 产生10个令牌
         */
        private final static int RATE = 10;
        private static long currentSize;

        public synchronized boolean get(int number) {
            if (number > currentSize) {
                return false;
            }
            if (currentSize <= 0) {
                return false;
            }
            currentSize--;
            return true;
        }

        public TokenBucket() {
            TokenBucket that = this;
            ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
            executorService.scheduleAtFixedRate(() -> {
                synchronized (that) {
                    currentSize = Math.min(currentSize + RATE, CAPACITY);
                    System.out.println("生成" + RATE + "个令牌，当前" + currentSize);
                }
            }, 0, 1, TimeUnit.SECONDS);
        }
    }
}