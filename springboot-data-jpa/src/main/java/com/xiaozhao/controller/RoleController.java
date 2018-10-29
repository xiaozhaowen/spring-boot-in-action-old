package com.xiaozhao.controller;

import com.xiaozhao.domain.Role;
import com.xiaozhao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaozhao
 * @date 2018/10/29下午4:11
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/list")
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Role findById(@PathVariable Integer id) {
        return roleRepository.findById(id).get();
    }

    @PostMapping("/add")
    public int add(@RequestBody Role role) {
        final Role newRole = roleRepository.save(role);
        return newRole.getId();
    }


    @PutMapping("/update")
    public String update(@RequestBody Role role) {
        final Role newRole = roleRepository.save(role);
        return newRole.getName();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        roleRepository.deleteById(id);
        return "删除成功";
    }


}
