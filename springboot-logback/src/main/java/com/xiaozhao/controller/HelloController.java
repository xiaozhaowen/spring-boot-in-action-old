package com.xiaozhao.controller;

import com.xiaozhao.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xiaozhao
 * @date 2018/10/24上午10:02
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @GetMapping("/greeting/{name}")
    public String sayHello(@PathVariable("name") String name) {
        logger.debug("我是DEBUG");
        logger.info("我是控制器，接收到了参数：" + name);
        return helloService.sayHello(name);
    }
}
