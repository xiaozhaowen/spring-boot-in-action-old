package com.xiaozhao.exception;

import com.xiaozhao.dto.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 传统系统中的有错误界面
 *
 * @author xiaozhao
 * @date 2018/10/23下午1:59
 */
//@ControllerAdvice
public class PageExceptionHandler {


    /**
     * 返回到错误页面，位于resources>templates>error.html文件
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
//    @ExceptionHandler(value = Exception.class)
    public ModelAndView pageExceptionHandle(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("url", req.getRequestURL());
        // 模板名称
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
