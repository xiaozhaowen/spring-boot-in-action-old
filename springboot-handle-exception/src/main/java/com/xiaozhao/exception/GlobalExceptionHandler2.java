package com.xiaozhao.exception;

import com.xiaozhao.dto.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理项目中的异常，既包含传统项目中的界面，也包含了rest形式的json返回
 *
 * @author xiaozhao
 * @date 2018/10/23下午3:12
 */
@RestControllerAdvice
public class GlobalExceptionHandler2 {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler2.class);

    @ExceptionHandler(Exception.class)
    public Object defaultExceptionHandle(Exception e, HttpServletRequest request) {
        boolean isAjax = isAjax(request);
        if (isAjax) {
            logger.error("Ajax 请求异常" + e.getMessage());
            HttpResult<String> result = new HttpResult<>();
            result.setCode(-1);
            result.setMsg(e.getMessage());
            return result;
        } else {
            logger.error("界面请求异常" + e.getMessage());
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.addObject("stackTrace", e.getStackTrace());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    /**
     * 判断网络请求是否为ajax
     *
     * @param req
     * @return
     */
    private boolean isAjax(HttpServletRequest req) {
        String contentTypeHeader = req.getHeader("Content-Type");
        String acceptHeader = req.getHeader("Accept");
        String xRequestedWith = req.getHeader("X-Requested-With");
        return (contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith);
    }
}
