package org.example.spring.resrouces;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author qiqiang
 * @date 2020-10-22 4:27 下午
 */
public class ClassPathResourcesExample {
    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource("富婆通讯录.txt");
        System.out.println(resource.getDescription());
        System.out.println(resource.getFilename());
        System.out.println(resource.getFile());
        System.out.println(StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8));
    }
}