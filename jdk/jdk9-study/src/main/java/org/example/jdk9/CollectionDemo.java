package org.example.jdk9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author qiqiang
 * @date 2020-10-14 2:07 下午
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
        System.out.println(set);
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println(list);
        Map<String, String> map = Map.of("A", "AV", "B", "BV");
        System.out.println(map);
    }
}