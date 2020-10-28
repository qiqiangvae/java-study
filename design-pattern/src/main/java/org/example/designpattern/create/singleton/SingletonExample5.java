package org.example.designpattern.create.singleton;

/**
 * 枚举
 *
 * @author qiqiang
 * @date 2020-10-23 10:16 上午
 */
public class SingletonExample5 {

    private SingletonExample5() {
    }

    public static SingletonExample5 getInstance() {
        return SingletonExample5Holder.INSTANCE.instance;
    }

    enum SingletonExample5Holder {
        INSTANCE;
        private SingletonExample5 instance;

        SingletonExample5Holder() {
            instance = new SingletonExample5();
        }
    }

    public static void main(String[] args) {
        SingletonExample5 instance1 = SingletonExample5.getInstance();
        SingletonExample5 instance2 = SingletonExample5.getInstance();
        System.out.println(instance1 == instance2);
    }
}