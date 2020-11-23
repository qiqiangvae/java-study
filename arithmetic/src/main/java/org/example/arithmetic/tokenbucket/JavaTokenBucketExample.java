package org.example.arithmetic.tokenbucket;

/**
 * 令牌桶思想：
 * 每秒产生固定的令牌到桶里，桶有容量限制，每次从桶里取出一个令牌使用
 *
 * @author qiqiang
 * @date 2020-10-30 10:25 上午
 */
public class JavaTokenBucketExample {
    /**
     * 令牌桶容量为100
     */
    private final static long CAPACITY = 100;
    /**
     * 1s 产生10个令牌
     */
    private final static int RATE = 10;
    private static long lastTime = System.currentTimeMillis();
    private static long currentSize;


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(100);
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "获取令牌" + (take() ? "成功" : "获取令牌失败"));
            }
        }, "线程1").start();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "获取令牌" + (take() ? "成功" : "获取令牌失败"));
            }
        }, "线程2").start();
    }

    public static synchronized boolean take() {
        // 如果当前令牌数量小于等于0，那么需要生产
        String threadName = Thread.currentThread().getName();
        if (currentSize <= 0) {
            System.out.println(threadName + "：令牌不够了");
            long currentTime = System.currentTimeMillis();
            long interval = currentTime - lastTime;
            long addSize = interval * RATE;
            if (addSize > 0) {
                lastTime = currentTime;
                long targetSize = addSize + currentSize;
                currentSize = Math.min(targetSize, CAPACITY);
            }
        }
        if (currentSize > 0) {
            currentSize--;
            System.out.println(threadName + "取出一个令牌，剩余" + currentSize);
            return true;
        }
        return false;
    }
}