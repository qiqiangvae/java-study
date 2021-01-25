package org.example.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author qiqiang
 */
public class ExampleInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        if (Stream.of(Object.class.getMethods())
                .map(Method::getName)
                .anyMatch(s -> methodInvocation.getMethod().getName().equals(s))) {
            return methodInvocation.proceed();
        }
        System.out.println("前置---------");
        return methodInvocation.proceed();
    }
}