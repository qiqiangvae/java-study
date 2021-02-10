package org.example.spring.shell;

import org.example.spring.shell.event.ChangeUserEvent;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.event.EventListener;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

/**
 * @author qiqiang
 */
@Component
public class MyPromptProvider implements PromptProvider {
    private String user;

    @Override
    public AttributedString getPrompt() {
        if (user == null) {
            user = "default";
        }
        return new AttributedString(user + ">");
    }

    @EventListener
    public void handle(ChangeUserEvent event) {
        this.user = event.getUser();
    }
}