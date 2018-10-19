package com.xiaozhao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接读取application.yml/properties 中的配置项
 *
 * @author xiaozhao
 * @date 2018/10/18下午4:59
 */
@RestController
@RequestMapping("/app_var")
public class AppVarController {


    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @Value("${playerInfo}")
    private String playerInfo;


    /**
     * 有层次关系的变量读取
     *
     * @return
     */
    @Value("${player.name}")
    private String h_name;

    @Value("${player.club}")
    private String h_club;


    @GetMapping("/info")
    public String getCustomConfigInfo() {
        return name + " " + age + " " + playerInfo;
    }

    @GetMapping("/hier")
    public String getHierachyInfo() {
        return h_name + "所在的俱乐部是：" + h_club;
    }

}
