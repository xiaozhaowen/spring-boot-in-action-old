package com.xiaozhao.exception;

/**
 * 针对rest错误的异常
 *
 * @author xiaozhao
 * @date 2018/10/23下午2:33
 */
public class RestException extends RuntimeException {
    public RestException(String message) {
        super(message);
    }
}
