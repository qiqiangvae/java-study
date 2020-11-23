package org.example.jdk9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiqiang
 * @date 2020-10-14 3:06 下午
 */
public class DiamondOperatorDemo {
    public static void main(String[] args) {
        // jdk9以前
        Map<String, String> map = new HashMap<String, String>(2) {{
            put("A", "AV");
            put("B", "BV");
        }};
        // jdk9以后
        Map<String, String> map2 = new HashMap<>(2) {{
            put("A", "AV");
            put("B", "BV");
        }};
    }
}