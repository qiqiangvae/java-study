package org.example.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qiqiang
 * @date 2020-10-29 5:41 下午
 */
public class ReentrantReadWriteLockExample {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();


    public static void main(String[] args) {

    }
}