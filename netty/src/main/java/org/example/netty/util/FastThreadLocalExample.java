package org.example.netty.util;

import io.netty.util.concurrent.FastThreadLocal;

/**
 * @author qiqiang
 * @date 2020-11-06 2:59 下午
 */
public class FastThreadLocalExample {
    private static final int COUNT = 10000;

    public static void main(String[] args) {
        FastThreadLocal<Integer> fastThreadLocal = new FastThreadLocal<>();
        fastThreadLocal.set(1);
        System.out.println(fastThreadLocal.get());
    }
}