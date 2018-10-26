package com.xiaozhao.controller;

import com.xiaozhao.domain.User;
import com.xiaozhao.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaozhao
 * @date 2018/10/26上午11:14
 */
@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return helloService.hello(name);
    }


    @GetMapping("/list")
    public List<User> list() {
        return helloService.userList();
    }
}
