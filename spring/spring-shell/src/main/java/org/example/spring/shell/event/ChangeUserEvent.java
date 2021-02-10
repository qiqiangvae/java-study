package org.example.spring.shell.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author qiqiang
 */
public class ChangeUserEvent extends ApplicationEvent {
    private String user;

    public ChangeUserEvent(Object source) {
        super(source);
        this.user = (String) source;
    }

    public String getUser() {
        return user;
    }
}