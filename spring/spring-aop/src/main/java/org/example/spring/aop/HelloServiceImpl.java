package org.example.spring.aop;

import org.springframework.stereotype.Service;

/**
 * @author qiqiang
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}