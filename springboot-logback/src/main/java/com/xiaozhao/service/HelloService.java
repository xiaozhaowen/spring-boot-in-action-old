package com.xiaozhao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author xiaozhao
 * @date 2018/10/24上午10:05
 */
@Service
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public String sayHello(String name) {
        logger.info("我是服务层");
        return "你好 " + name;
    }
}
