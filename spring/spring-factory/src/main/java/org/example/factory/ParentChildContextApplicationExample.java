package org.example.factory;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 父子容器 demo
 *
 * @author qiqiang
 * @date 2020-10-27 3:31 下午
 */
public class ParentChildContextApplicationExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext(ParentConfig.class);
        AnnotationConfigApplicationContext child = new AnnotationConfigApplicationContext();
        child.register(ChildConfig.class);
        child.setParent(parent);
        child.refresh();
        System.out.println("子容器获取父容器配置" + child.getBean("parentHello"));
        System.out.println("子容器获取自身配置" + child.getBean("childHello"));
        System.out.println("父容器获取自身配置" + child.getBean("parentHello"));
        // 以下代码会报错，父容器无法获取子容器内的 bean
        try {
            System.out.println("父容器获取子容器配置" + parent.getBean("childHello"));
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("父容器获取子容器配置失败：" + e.getMessage());
        }
    }

    @Configuration
    static class ParentConfig {
        @Bean
        public String parentHello() {
            return "parentHello";
        }

    }

    @Configuration
    static class ChildConfig {
        @Bean
        public String childHello() {
            return "childHello";
        }
    }
}