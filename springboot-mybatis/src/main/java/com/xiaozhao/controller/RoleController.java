package com.xiaozhao.controller;

import com.xiaozhao.domain.Role;
import com.xiaozhao.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaozhao
 * @date 2018/10/30上午9:49
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public List<Role> queryAll() {
        logger.info("查询所有的角色");
        return this.roleService.queryAll();
    }

    @RequestMapping("/one/{id}")
    public Role selectOne(@PathVariable Integer id) {
        return this.roleService.selectOne(id);
    }

    @RequestMapping("/add/{name}")
    public int add(@PathVariable String name) {
        Role role = new Role();
        role.setName(name);
        return this.roleService.add(role);
    }

    @RequestMapping("/update/{id}/{name}")
    public int update(@PathVariable Integer id, @PathVariable String name) {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        return this.roleService.update(role);
    }

    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable Integer id) {
        return this.roleService.delete(id);
    }
}
