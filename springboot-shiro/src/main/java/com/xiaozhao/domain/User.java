package com.xiaozhao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author xiaozhao
 * @date 2018/11/7下午2:08
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -8315794285126194641L;

    private Integer id;
    private String userName;
    private String password;
    private String status;
}
