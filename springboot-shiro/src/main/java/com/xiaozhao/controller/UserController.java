package com.xiaozhao.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 主页控制器，做一些权限控制
 *
 * @author xiaozhao
 * @date 2018/11/7下午3:56
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 需要用户有list操作权限
     *
     * @param model
     * @return
     */
    @RequiresPermissions("user:list")
    @RequestMapping("list")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        return "user";
    }

    /**
     * 需要用户有add操作权限
     *
     * @param model
     * @return
     */
    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public String userAdd(Model model) {
        model.addAttribute("value", "新增用户");
        return "user";
    }

    /**
     * 需要用户有delete操作权限
     *
     * @param model
     * @return
     */
    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public String userDelete(Model model) {
        model.addAttribute("value", "删除用户");
        return "user";
    }

}
