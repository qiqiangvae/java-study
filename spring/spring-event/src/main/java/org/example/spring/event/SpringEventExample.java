package org.example.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;

/**
 * @author qiqiang
 * @date 2020-11-06 10:15 上午
 */
public class SpringEventExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringEventExample.class);
        context.refresh();
        context.start();
        context.stop();
        context.close();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("contextRefreshedEvent");
    }

    @EventListener(ContextClosedEvent.class)
    public void contextClosedEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("contextClosedEvent");
    }

    @EventListener(ContextStartedEvent.class)
    public void contextStartedEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("contextStartedEvent");
    }

    @EventListener(ContextStoppedEvent.class)
    public void contextStoppedEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("contextStoppedEvent");
    }
}