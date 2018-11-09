package com.xiaozhao.dao;

import com.xiaozhao.domain.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户所属角色数据库访问
 *
 * @author xiaozhao
 * @date 2018/11/7下午3:42
 */
@Component
public interface UserRoleMapper {
    /**
     * 查询用户所属的角色列表
     *
     * @param username
     * @return
     */
    List<Role> findRolesByUsername(String username);
}
