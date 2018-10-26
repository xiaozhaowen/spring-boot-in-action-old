package com.xiaozhao.service;

import com.xiaozhao.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaozhao
 * @date 2018/10/26上午11:13
 */
@Service
public class HelloService {
    public String hello(String name) {
        return "Hello " + name;
    }

    public List<User> userList() {
        List<User> list = new ArrayList<>(2);
        list.add(new User(1, "张三"));
        list.add(new User(2, "李四"));
        return list;
    }
}
