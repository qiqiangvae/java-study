package org.example.spring.resrouces;

import org.springframework.core.io.UrlResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author qiqiang
 * @date 2020-10-22 4:20 下午
 */
public class UrlResourceExample {
    public static void main(String[] args) {
        try {
            UrlResource resource = new UrlResource(new URL("http://localhost"));
            System.out.println(resource.getDescription());
            System.out.println(StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}