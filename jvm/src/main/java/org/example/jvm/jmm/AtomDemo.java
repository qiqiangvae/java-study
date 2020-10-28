package org.example.jvm.jmm;

/**
 * @author qiqiang
 * @date 2020-10-16 12:54 下午
 */
public class AtomDemo {
    static int i = 0;

    public static void main(String[] args) {
        i++;
    }
}