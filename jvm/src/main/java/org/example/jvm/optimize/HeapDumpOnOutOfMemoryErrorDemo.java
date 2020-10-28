package org.example.jvm.optimize;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM 异常自动dump
 *
 * @author qiqiang
 * @date 2020-10-15 11:18 上午
 */
public class HeapDumpOnOutOfMemoryErrorDemo {
    public static void main(String[] args) {
        // 设置堆最大为 10m，设置出现 oom 时自动 dump 文件，文件名为 oom.dump
        // -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./oom.dump
        List<Object> list = new ArrayList<>(100);
        while (true) {
            list.add(new Object());
        }
    }
}