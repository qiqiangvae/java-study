package org.example.jdk8.parameter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qiqiang
 * @date 2020-11-06 10:40 上午
 */
public class ParameterExample {
    public static void main(String[] args) {
        for (Method method : ParameterExample.class.getMethods()) {
            String collect = Stream.of(method.getParameters()).map(Parameter::getName).collect(Collectors.joining(","));
            System.out.printf("%s的参数有%s\n", method.getName(), collect);
        }
    }

    public void f1(String p1, Integer p2) {

    }
    public void f2(String nam, Integer age) {

    }
}