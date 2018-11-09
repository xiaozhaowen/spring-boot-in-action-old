package com.xiaozhao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限实体类
 *
 * @author xiaozhao
 * @date 2018/11/7下午3:41
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -316747523328447976L;

    private Integer id;
    private String url;
    private String name;
}
