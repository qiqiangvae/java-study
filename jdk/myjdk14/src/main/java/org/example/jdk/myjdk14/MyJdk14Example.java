package org.example.jdk.myjdk14;

/**
 * @author qiqiang
 */
public class MyJdk14Example {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("123123")).start();
    }
}