package com.xnyc.blog.configure.interceptor;

import com.xnyc.blog.mapper.XnycMapper;
import com.xnyc.blog.meta.Constant;
import com.xnyc.blog.po.TManagerDo;
import com.xnyc.blog.po.TMemberDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在请求被处理之前调用
     * request.getRequestURI() ： /manager/managerIndex.html
     * request.getRequestURL() ： http://localhost:8082/manager/managerIndex.html
     * request.getServletPath() ： /manager/managerIndex.html
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String opType = (String) request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE.OP_TYPE);
        if (StringUtils.isEmpty(opType)) {
            log.info("LoginInterceptor opType is null.");
            setRedirectUrl(request, response);
            return false;
        }

        //从session中获取登录标识loginId：用户Id或管理员Id
        Long loginId = (Long)request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE.LOGIN_ID);
        if (loginId == null) {
            log.info("LoginInterceptor loginId is null.");
            setRedirectUrl(request, response);
            return false;
        }
//        if (Constant.OP_Type.USER.equals(opType)) {
//            TMemberDo userPo = dao.getMemberMapper().getByMemberId(loginId);
//            if (userPo == null) {
//                log.info("LoginInterceptor user NOt login.");
//                setRedirectUrl(request, response);
//                return false;
//            }
//        } else if (Constant.OP_Type.MANAGER.equals(opType)) {
//            TManagerDo adminPo = dao.getManagerMapper().getByManagerId(loginId);
//            if (adminPo == null) {
//                log.info("LoginInterceptor admin NOt login.");
//                setRedirectUrl(request, response);
//                return false;
//            }
//        }

        return true;
    }

    private void setRedirectUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 请求的是后台管理相关页面，则跳转后台登录页面
        if (StringUtils.hasText(request.getRequestURI()) && request.getRequestURI().startsWith("/manager/")) {
            response.sendRedirect("/manager/managerLogin.html");
        } else {
            response.sendRedirect("/");
        }
    }

    /**
     * 在请求被处理后，视图渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束后调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
