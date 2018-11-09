package com.xiaozhao.dto;

import java.util.HashMap;

/**
 * 返回给客户端的包装对象
 *
 * @author xiaozhao
 * @date 2018/11/7下午3:16
 */
public class HttpResult extends HashMap<String, Object> {

    private static final int CODE_SUCCESS = 0;
    private static final int CODE_FAIL = -1;
    private static final String MSG_SUCCESS = "操作成功";
    private static final String MSG_FAIL = "操作失败";
    private static final String CODE_KEY = "code";
    private static final String MSG_KEY = "msg";
    private static final String DATA_KEY = "data";


    private static final long serialVersionUID = -4492727166470965950L;

    public HttpResult() {
        put(CODE_KEY, CODE_SUCCESS);
        put(MSG_KEY, MSG_SUCCESS);
    }

    public static HttpResult error(String msg) {
        return error(CODE_FAIL, msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult result = new HttpResult();
        result.put(CODE_KEY, code);
        result.put(MSG_KEY, msg);
        return result;
    }

    public static HttpResult ok() {
        HttpResult result = new HttpResult();
        return result;
    }

    public static HttpResult ok(Object data) {
        HttpResult result = new HttpResult();
        result.put(DATA_KEY, data);
        return result;
    }


    @Override
    public HttpResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
