package org.example.jdk8.enums;

/**
 * @author qiqiang
 * @date 2020-11-02 10:16 上午
 */
public class EnumExample {
    public static void main(String[] args) {
        for (Version value : Version.values()) {
            System.out.println(value.ordinal());
        }
    }
}