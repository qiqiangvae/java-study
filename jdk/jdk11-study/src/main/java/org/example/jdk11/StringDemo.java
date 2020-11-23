package org.example.jdk11;

/**
 * @author qiqiang
 * @date 2020-10-14 3:18 下午
 */
public class StringDemo {
    public static void main(String[] args) {
        String text = " Hello JDK11 ";
        // 判断是否为空
        System.out.println(text.isBlank());
        // 去除首部空格
        System.out.println(text.strip());
        // 去除尾部空格
        System.out.println(text.stripTrailing());
        // 去除首部空格
        System.out.println(text.stripLeading());
        // 复制字符串
        System.out.println(text.repeat(3));
        // 统计行数
        System.out.println(text.lines().count());
    }
}