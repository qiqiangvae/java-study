package org.example.concurrency;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qiqiang
 * @date 2020-10-26 6:53 下午
 */
public class ConditionExample {
    private static final Lock LOCK = new ReentrantLock();
    private static final Condition EMPTY = LOCK.newCondition();
    private static final Condition FULL = LOCK.newCondition();
    private static final int CAPACITY = 10;
    private static final LinkedList<Object> LIST = new LinkedList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Consumer("张三"));
        executorService.execute(new Consumer("李四"));
        executorService.execute(new Producer());
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                LOCK.lock();
                try {
                    while (CAPACITY <= LIST.size()) {
                        System.out.println("仓库满了，等待消费");
                        FULL.await();
                    }
                    LIST.add(new Object());
                    System.out.println("新增一个元素，还剩" + LIST.size());
                    EMPTY.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                    try {
                        Thread.sleep(random.nextInt(300));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                LOCK.lock();
                try {
                    while (LIST.size() == 0) {
                        System.out.println("仓库空了，等待生产元素");
                        EMPTY.await();
                    }
                    LIST.removeFirst();
                    System.out.println(name + "取出一个元素，还剩" + LIST.size());
                    FULL.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}