package com.xiaozhao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * //TODO 文件过大的异常没能正确处理
 *
 * @author xiaozhao
 * @date 2018/10/25上午9:00
 */
@ControllerAdvice
public class MyExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView pageExceptionHandle(HttpServletRequest req, Exception e) throws Exception {
        logger.warn("全局错误处理");
        logger.warn(e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("url", req.getRequestURL());
        // 模板名称
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
