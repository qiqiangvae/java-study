package org.example.jdk9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author qiqiang
 * @date 2020-10-14 2:32 下午
 */
public class StreamDemo {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6).takeWhile(integer -> integer < 4).forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6).dropWhile(integer -> integer < 4).forEach(System.out::print);
        System.out.println();
        IntStream.iterate(2, x -> x < 10, x -> x + 3).forEach(x -> System.out.printf("%d\t", x));
    }
}