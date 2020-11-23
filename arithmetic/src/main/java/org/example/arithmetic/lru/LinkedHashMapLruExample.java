package org.example.arithmetic.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author qiqiang
 * @date 2020-11-06 5:37 下午
 */
public class LinkedHashMapLruExample {
    private static final int MAX_SIZE = 10;
    private static final Map<Integer, Integer> BUCKET = new LinkedHashMap<Integer, Integer>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_SIZE;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            BUCKET.put(i, i);
        }
        System.out.println(BUCKET.get(0));
        System.out.println(BUCKET.get(1));
        System.out.println(BUCKET.get(10));
    }
}