package com.xiaozhao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色实体类
 *
 * @author xiaozhao
 * @date 2018/11/7下午3:39
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -7713029747061173171L;

    private Integer id;
    private String name;
    private String memo;
}
