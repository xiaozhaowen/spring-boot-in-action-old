package com.xiaozhao.controller;

import com.xiaozhao.exception.RestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试用的控制器
 *
 * @author xiaozhao
 * @date 2018/10/23上午10:37
 */
@Controller
@RequestMapping
public class UserController {

    /**
     * 传统项目中的界面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/page")
    public String page() throws Exception {
        throw new Exception("发生了界面错误");
    }

    /**
     * rest服务，返回json数据
     *
     * @return
     * @throws RestException
     */
    @GetMapping("/rest")
    @ResponseBody
    public String hello() throws RestException {
        throw new RestException("发生自定义rest错误");
    }

    /**
     * 正常返回界面
     *
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 返回一个不存在的界面
     *
     * @return
     */
    @GetMapping("/no_page")
    public String noPage() {
        return "noPage";
    }


}
