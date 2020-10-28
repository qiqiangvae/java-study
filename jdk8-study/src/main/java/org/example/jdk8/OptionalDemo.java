package org.example.jdk8;

import java.util.Optional;

/**
 * @author qiqiang
 * @date 2020-10-21 4:44 下午
 */
public class OptionalDemo {
    public static void main(String[] args) {
        System.out.println(Optional.empty().isPresent());
    }
}