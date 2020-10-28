package org.example.jdk11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author qiqiang
 * @date 2020-10-14 3:34 下午
 */
public class ReadWriteFileDemo {
    public static void main(String[] args) throws IOException {
        Files.writeString(
                Path.of("./", "poetry.txt"),
                "黄河之水天上来",
                StandardCharsets.UTF_8);
        String text = Files.readString(
                Paths.get("./poetry.txt"),
                StandardCharsets.UTF_8);
        System.out.println(text);
    }
}