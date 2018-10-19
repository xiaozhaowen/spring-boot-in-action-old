package com.xiaozhao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 球员信息的实体类
 *
 * @author xiaozhao
 * @date 2018/10/19上午10:09
 */
@ConfigurationProperties(prefix = "player")
@Component // 此注解可加可不加
public class Player {

    private String name;
    private String club;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
