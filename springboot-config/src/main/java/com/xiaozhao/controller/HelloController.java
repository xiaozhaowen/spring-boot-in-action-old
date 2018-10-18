package com.xiaozhao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaozhao
 * @date 2018/10/18下午4:59
 */
@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
