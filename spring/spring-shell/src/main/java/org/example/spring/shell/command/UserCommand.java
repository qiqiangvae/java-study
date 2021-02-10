package org.example.spring.shell.command;

import org.example.spring.shell.event.ChangeUserEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author qiqiang
 */
@ShellComponent
@ShellCommandGroup("user")
public class UserCommand implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @ShellMethod("change user")
    public String su(String user) {
        applicationContext.publishEvent(new ChangeUserEvent(user));
        return user;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}