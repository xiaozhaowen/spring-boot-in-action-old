package com.xiaozhao.controller;

import com.xiaozhao.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * JDBC Template 使用示例
 *
 * @author xiaozhao
 * @date 2018/10/29下午1:57
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过构造函数注入
     *
     * @param jdbcTemplate
     */
    @Autowired
    public RoleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 获取角色列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<Role> queryRoles() {
        String sql = "select id,name from role";
        return this.jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(Role.class));
    }


    /**
     * 找指定id的角色
     *
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public Role findRole(@PathVariable Integer id) {
        String sql = "select id,name from role where id = ? ";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Role.class));
    }

    /**
     * 新增一个角色
     *
     * @param role
     * @return
     */
    @PostMapping("/add")
    public int addRole(@RequestBody Role role) {
        System.out.println("进入到add控制器方法");
        System.out.println(role);
        String sql = "insert into role(name) values(?)";
        return this.jdbcTemplate.update(sql, role.getName());
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public int delUser(@PathVariable Integer id) {
        String sql = "DELETE FROM role WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    /**
     * 编辑
     *
     * @param role
     * @return
     */
    @PutMapping("/update")
    public int editUser(@RequestBody Role role) {
        String sql = "UPDATE role SET name = ?  WHERE id = ?";
        return jdbcTemplate.update(sql, role.getName(), role.getId());
    }

}
