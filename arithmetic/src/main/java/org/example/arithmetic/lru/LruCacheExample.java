package org.example.arithmetic.lru;

/**
 * @author qiqiang
 * @date 2020-11-06 6:05 下午
 */
public class LruCacheExample {
    public static void main(String[] args) {
        LruCache<Integer> cache = new LruCache<>(10);
        for (int i = 0; i < 15; i++) {
            String key = String.valueOf(i);
            cache.put(key, i);
            System.out.println(cache.get(key));
            System.out.println(cache);
        }
        System.out.println(cache.get("10"));
        System.out.println(cache);
    }
}