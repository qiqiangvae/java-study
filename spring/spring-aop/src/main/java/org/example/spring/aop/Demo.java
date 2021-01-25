package org.example.spring.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author qiqiang
 */
public class Demo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(HelloService.class, new ExampleInterceptor());
        HelloService proxy = (HelloService) proxyFactory.getProxy();
        String qiqiang = proxy.hello("qiqiang");
        System.out.println(qiqiang);
    }
}