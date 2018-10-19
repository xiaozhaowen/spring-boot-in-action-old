package com.xiaozhao.controller;

import com.xiaozhao.config.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 把application.yml/properties 中的自定义配置，读取到一个实体类中
 *
 * @author xiaozhao
 * @date 2018/10/19上午10:14
 */
@RestController
@RequestMapping("/app_bean")
@EnableConfigurationProperties({Player.class})
public class AppBeanController {
    @Autowired
    private Player player;

    @GetMapping("/info")
    public String getPlayerInfo() {
        return "app_bean: " + player.getName() + " " + player.getClub() + " " + player.getAge();
    }

}
