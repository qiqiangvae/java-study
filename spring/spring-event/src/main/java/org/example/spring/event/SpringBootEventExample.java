package org.example.spring.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.EventListener;

/**
 * @author qiqiang
 * @date 2020-11-06 10:29 上午
 */
public class SpringBootEventExample {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEventExample.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("applicationReadyEvent");
    }

    @EventListener(ApplicationPreparedEvent.class)
    public void applicationPreparedEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        System.out.println("applicationPreparedEvent");
    }

    @EventListener(ApplicationContextInitializedEvent.class)
    public void applicationContextInitializedEvent(ApplicationContextInitializedEvent applicationContextInitializedEvent) {
        System.out.println("applicationContextInitializedEvent");
    }

    @EventListener(ApplicationEnvironmentPreparedEvent.class)
    public void applicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("applicationEnvironmentPreparedEvent");
    }

    @EventListener(ApplicationFailedEvent.class)
    public void applicationFailedEvent(ApplicationFailedEvent applicationFailedEvent) {
        System.out.println("applicationFailedEvent");
    }

    @EventListener(ApplicationStartedEvent.class)
    public void applicationStartedEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("applicationStartedEvent");
    }

    @EventListener(ApplicationStartingEvent.class)
    public void applicationStartingEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("applicationStartingEvent");
    }

}