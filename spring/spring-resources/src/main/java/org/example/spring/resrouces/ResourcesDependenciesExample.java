package org.example.spring.resrouces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author qiqiang
 * @date 2020-10-22 4:55 下午
 */
public class ResourcesDependenciesExample {
    @Value("classpath:富婆通讯录.txt")
    private Resource resource;

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ResourcesDependenciesExample.class);
        ResourcesDependenciesExample bean = context.getBean(ResourcesDependenciesExample.class);
        System.out.println(bean.resource.getFilename());
        System.out.println(StreamUtils.copyToString(bean.resource.getInputStream(), StandardCharsets.UTF_8));
    }
}