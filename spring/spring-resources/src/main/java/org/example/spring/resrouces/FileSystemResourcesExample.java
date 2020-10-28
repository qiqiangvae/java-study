package org.example.spring.resrouces;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * @author qiqiang
 * @date 2020-10-22 4:27 下午
 */
public class FileSystemResourcesExample {
    public static void main(String[] args) throws IOException {
        FileSystemResource resource = new FileSystemResource("spring/spring-resources/src/main/resources/富婆通讯录.txt");
        System.out.println(resource.getDescription());
        System.out.println(resource.getFilename());
        System.out.println(resource.getFile());
        System.out.println(StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8));
    }
}