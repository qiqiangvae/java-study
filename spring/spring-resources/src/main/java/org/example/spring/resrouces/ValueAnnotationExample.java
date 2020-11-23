package org.example.spring.resrouces;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author qiqiang
 * @date 2020-11-06 10:07 上午
 */
@Configuration
public class ValueAnnotationExample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValueAnnotationExample.class);
    }

    @Component
    static class Bean implements InitializingBean {
        @Value("${classpath:富婆通讯录.txt}")
        private Resource resource;

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println(resource);
        }
    }
}