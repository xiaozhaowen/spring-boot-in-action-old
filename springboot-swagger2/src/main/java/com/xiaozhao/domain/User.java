package com.xiaozhao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author xiaozhao
 * @date 2018/10/19下午3:35
 */
@ApiModel
public class User implements Serializable {

    private static final long serialVersionUID = -1084928517040754103L;
    @ApiModelProperty(value = "用户id", name = "id", required = false)
    private Integer id;

    @ApiModelProperty(value = "用户名称", name = "name", required = true,example = "张飒")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
