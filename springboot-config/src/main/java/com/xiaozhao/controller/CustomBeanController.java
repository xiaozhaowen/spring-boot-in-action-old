package com.xiaozhao.controller;

import com.xiaozhao.config.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 把自定义配置文件读取到一个实体类中
 *
 * @author xiaozhao
 * @date 2018/10/19上午10:31
 */
@RestController
@RequestMapping("/cus_bean")
public class CustomBeanController {

    @Autowired
    private Setting setting;


    @GetMapping("/info")
    public String getInfo() {
        return setting.getName() + ":" + setting.getAge();
    }
}
