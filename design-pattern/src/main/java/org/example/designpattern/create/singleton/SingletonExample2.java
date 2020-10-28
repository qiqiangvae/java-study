package org.example.designpattern.create.singleton;

/**
 * 懒汉式线程安全版，去掉 volatile 和 synchronized 则是线程不安去版本
 *
 * @author qiqiang
 * @date 2020-10-23 10:16 上午
 */
public class SingletonExample2 {
    private static volatile SingletonExample2 instance;

    private SingletonExample2() {
    }

    public static synchronized SingletonExample2 getInstance() {
        if (instance == null) {
            instance = new SingletonExample2();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonExample2 instance1 = SingletonExample2.getInstance();
        SingletonExample2 instance2 = SingletonExample2.getInstance();
        System.out.println(instance1 == instance2);
    }
}