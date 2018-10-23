package com.xiaozhao.exception;

import com.xiaozhao.dto.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 包含页面和json 两种方式的错误处理
 *
 * @author xiaozhao
 * @date 2018/10/23下午2:20
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理传统系统中的异常，导航到错误页面
     *
     * @param req
     * @param e
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
    public ModelAndView pageExceptionHandle(HttpServletRequest req, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("url", req.getRequestURL());
        // 模板名称
        modelAndView.setViewName("error");
        logger.error(e.getMessage());
        return modelAndView;
    }

    /**
     * 返回json
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(value = RestException.class)
//    @ResponseBody
    public HttpResult<String> restExceptionHandle(Exception e) {
        HttpResult<String> result = new HttpResult<>();
        result.setCode(-1);
        result.setMsg(e.getMessage());
        logger.error(e.getMessage());
        return result;
    }


}
