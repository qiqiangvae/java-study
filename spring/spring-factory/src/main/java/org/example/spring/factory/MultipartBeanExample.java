package org.example.spring.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiqiang
 * @date 2020-12-02 15:57
 */
@Configuration
public class MultipartBeanExample {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MultipartBeanExample.class);
        ParentBean bean = context.getBean(ParentBean.class);
        System.out.println(bean);
    }
    

    @Bean
    public ParentBean parentBean() {
        return new ParentBean();
    }

    @Bean
    public ChildBean childBean() {
        return new ChildBean();
    }
}