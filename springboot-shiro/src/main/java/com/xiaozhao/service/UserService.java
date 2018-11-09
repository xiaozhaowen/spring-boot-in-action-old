package com.xiaozhao.service;

import com.xiaozhao.dao.UserMapper;
import com.xiaozhao.dao.UserPermissionMapper;
import com.xiaozhao.dao.UserRoleMapper;
import com.xiaozhao.domain.Permission;
import com.xiaozhao.domain.Role;
import com.xiaozhao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户查询相关的服务
 * 1）查询用户信息
 * 2）查询用户所属角色信息
 * 3）查询用户所拥有的权限信息
 *
 * @author xiaozhao
 * @date 2018/11/7下午2:13
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    /**
     * 根据用户名查找对应的用户信息
     *
     * @param userName
     * @return
     */
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    /**
     * 根据用户名查找对应的角色集合
     *
     * @param username
     * @return
     */
    public List<Role> findRolesByUsername(String username) {
        return userRoleMapper.findRolesByUsername(username);
    }

    /**
     * 根据用户名查找对应的操作权限集合
     *
     * @param username
     * @return
     */
    public List<Permission> findPermsByUsername(String username) {
        return userPermissionMapper.findPermsByUsername(username);
    }

}
