package org.example.jdk9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author qiqiang
 * @date 2020-10-14 2:57 下午
 */
public class TryWithResourcesDemo {
    public static void main(String[] args) throws IOException {
        Reader inputString = new StringReader("hello");
        BufferedReader br = new BufferedReader(inputString);
        try (br) {
            System.out.println(br.readLine());;
        }
    }
}