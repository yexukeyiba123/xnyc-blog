package com.xnyc.blog.configure.advice;

import com.xnyc.blog.api.apientity.AbstractResponse;
import com.xnyc.blog.domain.exception.ServiceException;
import com.xnyc.blog.meta.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Controller相关配置：异常拦截
 *
 * @author : 郑杜
 * @date : 2019/08/11
 */
@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public AbstractResponse onValidationException(HttpServletRequest httpRequest, MethodArgumentNotValidException e) {
        AbstractResponse resp = new AbstractResponse();
        resp.setResultCode(ResultCode.ERROR_PARAM);

        String description = "参数错误。";
        List<ObjectError> list = e.getBindingResult().getAllErrors();
        if (!list.isEmpty() && list.get(0) instanceof FieldError) {
            FieldError error = (FieldError) list.get(0);
            description += "详情：" + String.format("[%s=%s]%s",
                    error.getField(), error.getRejectedValue(), error.getDefaultMessage());
            log.error("{} validation error {}", httpRequest.getRequestURI(), resp);
        } else {
            log.error("{} validation error {}", httpRequest.getRequestURI(), e.getMessage());
        }

        resp.setDescription(description);
        return resp;
    }

    @ExceptionHandler(value = ServiceException.class)
    public AbstractResponse onServiceException(HttpServletRequest request,  ServiceException e) {
        log.error("WebControllerAdvice onServiceException is: {}, {}", e.getMessage(), e);
        AbstractResponse resp = new AbstractResponse();
        resp.setResultCode(e.getResultCode());
        resp.setDescription(e.getMessage());
        return resp;
    }

    @ExceptionHandler(value = Exception.class)
    public AbstractResponse onException(HttpServletRequest http, Exception e) {
        log.error("WebControllerAdvice onException is: {}, {}", e.getMessage(), e);
        AbstractResponse resp = new AbstractResponse();
        resp.setResultCode(ResultCode.UNKNOWN_ERROR);
        resp.setDescription("对不起，服务器出错啦！！！");
        return resp;
    }
}
