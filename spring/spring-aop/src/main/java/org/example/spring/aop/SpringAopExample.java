package org.example.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author qiqiang
 */
@Configuration
@ComponentScan(basePackageClasses = AopConfig.class)
public class SpringAopExample {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAopExample.class);
        HelloService helloService = context.getBean(HelloService.class);
        String result = helloService.hello("qiqiang");
        System.out.println(result);
    }


}