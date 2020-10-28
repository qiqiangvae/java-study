package org.example.jvm.optimize;

import java.lang.management.ManagementFactory;

/**
 * @author qiqiang
 * @date 2020-10-15 11:30 上午
 */
public class SurvivorRatioDemo {
    public static void main(String[] args) throws InterruptedException {
        // -XX:SurvivorRatio=8
        // java -Xmn10m -Xmx20m -XX:SurvivorRatio=3 org.exmaple.jvmoptimize.SurvivorRatioDemo
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        while (true) {
            new Object();
            new Object();
            new Object();
        }
    }
}