package com.xiaozhao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义配置实体类
 *
 * @author xiaozhao
 * @date 2018/10/18下午4:59
 */
@Configuration
@ConfigurationProperties(prefix = "com.test")
@PropertySource("classpath:config/settings.properties")
public class Setting {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
