package org.example.jvm.optimize;

import java.io.IOException;

/**
 * @author qiqiang
 * @date 2020-10-16 10:13 上午
 */
public class GcDemo {
    private static int c = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        // -Xmx30m -Xmn20m -verbose:gc
        System.out.println("开始");
        System.in.read();
        new Thread(() -> {
            while (true) {
                f();
            }
        }).start();
        while (true) {
            System.in.read();
            System.out.println("手动GC");
            System.gc();
        }
    }

    private static void f() {
        byte[] obj = new byte[1024 * 500];
        System.out.println(++c);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}