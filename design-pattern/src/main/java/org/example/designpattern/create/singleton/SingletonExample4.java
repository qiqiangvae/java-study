package org.example.designpattern.create.singleton;

/**
 * 静态内部类
 *
 * @author qiqiang
 * @date 2020-10-23 10:16 上午
 */
public class SingletonExample4 {

    private SingletonExample4() {
    }

    public static SingletonExample4 getInstance() {
        return SingletonExample4Holder.instance;
    }

    static class SingletonExample4Holder {
        private static final SingletonExample4 instance = new SingletonExample4();
    }

    public static void main(String[] args) {
        SingletonExample4 instance1 = SingletonExample4.getInstance();
        SingletonExample4 instance2 = SingletonExample4.getInstance();
        System.out.println(instance1 == instance2);
    }
}