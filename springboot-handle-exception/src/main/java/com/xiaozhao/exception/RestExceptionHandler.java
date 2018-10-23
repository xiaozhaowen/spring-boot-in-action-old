package com.xiaozhao.exception;

import com.xiaozhao.dto.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理类似rest风格的接口，返回json
 *
 * @author xiaozhao
 * @date 2018/10/23下午1:32
 */
//@RestControllerAdvice
public class RestExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 返回json
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
    public HttpResult<String> restExceptionHandle(Exception e) {
        logger.error(e.getMessage());
        HttpResult<String> result = new HttpResult<>();
        result.setCode(-1);
        result.setMsg(e.getMessage());
        return result;
    }
}
