package org.example.jdk.myjdk14;

/**
 * @author qiqiang
 */
public class Book {
    static {
        System.loadLibrary("jniFood");
    }

    /**
     * 用于存储C++层的对象指针
     */
    private int mObject;

    public Book(String name) {
        setBookParam(name);
    }

    public native void setBookParam(String name);

    public native String getName();

    public static void main(String[] args) {
        Book book1 = new Book("倚天屠龙记");
        Book book2 = new Book("神雕侠侣");

        System.out.printf("书名：%s%n", book1.getName());
        System.out.printf("书名：%s%n", book2.getName());
    }
}