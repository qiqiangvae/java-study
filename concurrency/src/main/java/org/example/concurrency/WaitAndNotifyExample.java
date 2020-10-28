package org.example.concurrency;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qiqiang
 * @date 2020-10-27 9:24 上午
 */
public class WaitAndNotifyExample {
    private static final int CAPACITY = 10;
    private static final LinkedList<Object> LIST = new LinkedList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Consumer());
        executorService.execute(new Producer());
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                synchronized (LIST) {
                    try {
                        //仓库满了
                        while (LIST.size() >= CAPACITY) {
                            System.out.println("仓库满了，等待消费");
                            LIST.wait();
                        }
                        LIST.add(new Object());
                        System.out.println("新增一个元素，当前数量" + LIST.size());
                        LIST.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            Thread.sleep(random.nextInt(500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                synchronized (LIST) {
                    try {
                        //仓库满了
                        while (LIST.size() == 0) {
                            System.out.println("仓库空了，等待生产");
                            LIST.wait();
                        }
                        LIST.removeFirst();
                        System.out.println("消费一个元素，还剩" + LIST.size());
                        LIST.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            Thread.sleep(random.nextInt(500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}