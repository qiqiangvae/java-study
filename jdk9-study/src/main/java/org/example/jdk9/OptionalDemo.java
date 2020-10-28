package org.example.jdk9;


import java.util.Optional;

/**
 * @author qiqiang
 * @date 2020-10-14 5:26 下午
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional.of("A").ifPresentOrElse(System.out::println, () -> System.out.println("元素为空"));
    }
}