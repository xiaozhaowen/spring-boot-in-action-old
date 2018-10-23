package com.xiaozhao.service;

import com.xiaozhao.exception.RestException;
import org.springframework.stereotype.Service;

/**
 * @author xiaozhao
 * @date 2018/10/23下午2:00
 */
@Service
public class UserService {
    public String hello() throws Exception {
        throw new RestException("发生在服务层的错误");
    }
}
