package com.xiaozhao.dao;

import com.xiaozhao.domain.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户权限数据库访问
 *
 * @author xiaozhao
 * @date 2018/11/7下午3:52
 */
@Component
public interface UserPermissionMapper {

    /**
     * 根据用户名查询用户所拥有的操作权限集合
     *
     * @param username
     * @return
     */
    List<Permission> findPermsByUsername(String username);
}
