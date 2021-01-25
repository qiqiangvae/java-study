package org.example.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiqiang
 * @date 2020-12-20 20:27
 */
@RestController
public class MyController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}