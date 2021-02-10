package org.example.spring.shell.command;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author qiqiang
 */
@ShellComponent
@ShellCommandGroup("math")
public class MathCommand {

    @ShellMethod(value = "Add two integers together")
    public int add(@ShellOption({"-a", "--a"}) int a, int b) {
        System.out.printf("%d + %d \n", a, b);
        return a + b;
    }
}