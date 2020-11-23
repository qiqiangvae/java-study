package org.example.concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qiqiang
 * @date 2020-10-29 2:48 下午
 */
public class ThreadInterruptedExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程睡觉");
                    LockSupport.park();
//                    Thread.sleep(5000);
                    System.out.println("线程醒了");
                } catch (Exception e) {
                    System.out.println("线程是否被中断" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                } finally {
                    System.out.println("线程是否被中断" + Thread.currentThread().isInterrupted());
                    System.out.println("线程是否被中断" + Thread.interrupted());
                    System.out.println("线程是否被中断" + Thread.currentThread().isInterrupted());
                    System.out.println("finally 方法");
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
//        LockSupport.unpark(thread);
        Thread.sleep(2000);
    }
}