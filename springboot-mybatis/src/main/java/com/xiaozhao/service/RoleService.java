package com.xiaozhao.service;

import com.xiaozhao.dao.RoleMapper;
import com.xiaozhao.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaozhao
 * @date 2018/10/30上午9:47
 */
@Service
public class RoleService {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private RoleMapper roleMapper;


    /**
     * 查询所有的角色
     *
     * @return
     */

    public List<Role> queryAll() {

        return this.roleMapper.queryAll();

    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */

    public Role selectOne(Integer id) {

        return this.roleMapper.selectOne(id);

    }

    /**
     * 新增
     *
     * @param role
     * @return
     */

    public int add(Role role) {

        return this.roleMapper.add(role);

    }

    /**
     * 修改
     *
     * @param role
     * @return
     */

    public int update(Role role) {

        return this.roleMapper.update(role);

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */

    public int delete(Integer id) {

        return this.roleMapper.delete(id);

    }
}
