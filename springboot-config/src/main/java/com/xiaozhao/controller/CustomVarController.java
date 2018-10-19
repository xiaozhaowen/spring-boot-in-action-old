package com.xiaozhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接读取自定义配置文件中的值
 *
 * @author xiaozhao
 * @date 2018/10/19上午10:20
 */
@RestController
@RequestMapping("/cus_var")
@PropertySource("classpath:config/settings.properties")
public class CustomVarController {

    @Autowired
    private Environment environment;

    @GetMapping("/info")
    public String getInfo() {
        String name = environment.getProperty("com.test.name");
        int age = Integer.valueOf(environment.getProperty("com.test.age"));
        return name + ":" + age;
    }
}
