package org.example.spring.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @author qiqiang
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new ExampleInterceptor());
        proxyFactory.setTarget(new HelloServiceImpl());
        HelloService proxy = (HelloService) proxyFactory.getProxy();
        String qiqiang = proxy.hello("qiqiang");
        System.out.println(qiqiang);
    }
}