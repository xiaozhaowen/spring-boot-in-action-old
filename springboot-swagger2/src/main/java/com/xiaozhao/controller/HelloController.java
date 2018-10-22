package com.xiaozhao.controller;

import com.xiaozhao.domain.User;
import com.xiaozhao.dto.HttpResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger2 示例
 *
 * @author xiaozhao
 * @date 2018/10/19下午3:17
 */
@RestController
@RequestMapping("/api")
@Api(value = "Welcome", tags = {"User Guide"})
public class HelloController {

    /**
     * 无参数，只有说明
     *
     * @return 返回字符串
     */
    @GetMapping("/hi")
    @ApiOperation(value = "问候语", notes = "这是一个问候", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public String hello() {
        return "Hell World";
    }

    /**
     * 无参数
     *
     * @return 返回一个对象
     */
    @GetMapping("/list")
    @ApiOperation(value = "列表", notes = "获取用户列表", httpMethod = "GET")
    public HttpResult list() {
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(0);
        httpResult.setMsg("");
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("James");
        list.add(user);
        httpResult.setData(list);
        return httpResult;
    }


    /**
     * 有一个简单类型的参数，rest风格
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查找用户", notes = "查找某个用户的详细信息")
    @ApiImplicitParam(name = "id", value = "用户唯一标识", required = true, dataType = "Long", paramType = "path")
    public User getBook(@PathVariable Long id) {
        System.out.println(id);
        User user = new User();
        user.setId(1);
        user.setName("库里");
        return user;
    }

    /**
     * 有一个引用类型的参数
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "添加一个新的用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User")
    public String postBook(@RequestBody User user) {
        System.out.println(user);
        return "添加用户成功";
    }


    /**
     * 有一个简单类型的参数和一个引用类型的参数
     *
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    })
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println(id);
        System.out.println(user.getId());
        System.out.println(user.getName());
        return "修改成功";
    }

    /**
     * 有一个Long的参数
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del_user/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户", notes = "根据id来删除指定用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    public String deleteUser(@PathVariable Long id) {
        System.out.println("删除用户：" + id);
        return "success";
    }

    /**
     * 使用该注解忽略这个API
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiIgnore
    public String jsonTest() {
        return " hi you!";
    }


    @ApiOperation("更改用户信息")
    @PostMapping("/updateUserInfo")
    public int test(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) User user) {
        return 1;
    }
}
