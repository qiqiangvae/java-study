package org.example.jvm.optimize;

/**
 * @author qiqiang
 * @date 2020-10-16 9:16 上午
 */
public class PretenureSizeThresholdDemo {
    public static void main(String[] args) throws InterruptedException {
        // -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
        byte[] bigObject;
        bigObject = new byte[4 * 1024 * 1024];
    }
}