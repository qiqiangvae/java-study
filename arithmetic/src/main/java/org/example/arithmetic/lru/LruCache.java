package org.example.arithmetic.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiqiang
 * @date 2020-11-06 5:41 下午
 */
public class LruCache<T> {
    /**
     * 容量大小
     */
    private final int capacity;
    private int size;
    /**
     * 头尾节点
     */
    private final Node<T> head;
    private final Node<T> tail;
    private final Map<String, Node<T>> cache = new HashMap<>();

    public LruCache(int capacity) {
        this.capacity = capacity;
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.pre = head;
    }

    public T get(String key) {
        Node<T> node = cache.get(key);
        if (node == null) {
            return null;
        } else {
            remove(node);
            add(node);
            return node.value;
        }
    }

    public void put(String key, T value) {
        Node<T> node = new Node<>();
        node.key = key;
        node.value = value;
        add(node);
        if (size > capacity) {
            remove(head.next);
        }
    }

    private void add(Node<T> node) {
        cache.put(node.key, node);
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        size += 1;
    }

    private void remove(Node<T> node) {
        cache.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
        size -= 1;

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("head");
        Node<T> current = head.next;
        while (current != null) {
            builder.append("--");
            if (current == tail) {
                builder.append("tail");
            } else {
                builder.append(current.key);
            }
            current = current.next;
        }
        return builder.toString();
    }

    static class Node<T> {
        String key;
        T value;
        Node<T> next;
        Node<T> pre;
    }
}