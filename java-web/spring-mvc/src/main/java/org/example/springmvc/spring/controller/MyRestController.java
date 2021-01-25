package org.example.springmvc.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiqiang
 * @date 2020-12-20 19:30
 */
@RestController
public class MyRestController {
    @RequestMapping("test")
    public String test() {
        return "test";
    }
}