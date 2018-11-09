package com.xiaozhao.dao;

import com.xiaozhao.domain.User;
import org.springframework.stereotype.Component;

/**
 * 用户数据库访问
 *
 * @author xiaozhao
 * @date 2018/11/7下午2:12
 */
@Component
public interface UserMapper {

    /**
     * 根据用户名查询对应的用户信息
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
