package org.example.designpattern.create.singleton;

/**
 * 饿汉式
 *
 * @author qiqiang
 * @date 2020-10-23 10:16 上午
 */
public class SingletonExample1 {
    private static final SingletonExample1 instance = new SingletonExample1();

    private SingletonExample1() {
    }

    public static SingletonExample1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonExample1 instance1 = SingletonExample1.getInstance();
        SingletonExample1 instance2 = SingletonExample1.getInstance();
        System.out.println(instance1 == instance2);
    }
}