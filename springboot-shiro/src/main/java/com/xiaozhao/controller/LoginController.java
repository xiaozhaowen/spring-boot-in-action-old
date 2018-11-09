package com.xiaozhao.controller;

import com.xiaozhao.domain.User;
import com.xiaozhao.dto.HttpResult;
import com.xiaozhao.service.UserService;
import com.xiaozhao.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 *
 * @author xiaozhao
 * @date 2018/11/7下午2:16
 */
@Controller
public class LoginController {

    /**
     * 查询用户信息服务
     */
    @Autowired
    private UserService userService;

    /**
     * 返回登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 测试方法，得到一个用户数据，返回json格式
     *
     * @return
     */
    @GetMapping("/user")
    @ResponseBody
    public User gerUser() {
        return userService.findByUserName("mrbird");
    }

    /**
     * 跳转首页
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    /**
     * 默认情况下跳转首页
     *
     * @return
     */
    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    /**
     * 登录方法，post形式
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HttpResult login(String username, String password) {
        String encPassword = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, encPassword);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            return HttpResult.ok();
        } catch (UnknownAccountException e) {
            return HttpResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return HttpResult.error(e.getMessage());
        } catch (LockedAccountException e) {
            return HttpResult.error(e.getMessage());
        } catch (AuthenticationException e) {
            return HttpResult.error("认证失败");
        }
    }

    /**
     * 没有权限跳转的界面
     *
     * @return
     */
    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    /**
     * 用户注销登录
     *
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/index";
    }
}
