package org.example.designpattern.create.singleton;

/**
 * 双重校验锁
 *
 * @author qiqiang
 * @date 2020-10-23 10:16 上午
 */
public class SingletonExample3 {
    private volatile static SingletonExample3 instance;

    private SingletonExample3() {
    }

    public static SingletonExample3 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample3.class) {
                instance = new SingletonExample3();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonExample3 instance1 = SingletonExample3.getInstance();
        SingletonExample3 instance2 = SingletonExample3.getInstance();
        System.out.println(instance1 == instance2);
    }
}