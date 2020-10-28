package org.example.jdk11;

import java.util.stream.Stream;

/**
 * @author qiqiang
 * @date 2020-10-14 3:14 下午
 */
public class LambdaVarDemo {
    public static void main(String[] args) {
        Stream.of(1, 2, 3).forEach((var i) -> {
            System.out.println(i);
        });
    }
}