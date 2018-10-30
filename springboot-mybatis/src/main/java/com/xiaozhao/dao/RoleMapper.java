package com.xiaozhao.dao;

import com.xiaozhao.domain.Role;

import java.util.List;

/**
 * @author xiaozhao
 * @date 2018/10/30上午9:45
 */

/**

 * @Mapper 如果没有在SpringbootLearingApplication添加@MapperScan 注解的话，这里都需要一个这样的注解

 */
public interface RoleMapper {
    /**

     * 查询所有的角色

     *

     * @return

     */

    List<Role> queryAll();

    /**

     * 查询单个

     *

     * @param id

     * @return

     */

    Role selectOne(Integer id);

    /**

     * 新增

     *

     * @param role

     * @return

     */

    int add(Role role);

    /**

     * 修改

     *

     * @param role

     * @return

     */

    int update(Role role);

    /**

     * 删除

     *

     * @param id

     * @return

     */

    int delete(Integer id);
}
