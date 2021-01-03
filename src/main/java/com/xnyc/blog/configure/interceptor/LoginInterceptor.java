package com.xnyc.blog.configure.interceptor;

import com.xnyc.blog.mapper.XnycMapper;
import com.xnyc.blog.meta.Constant;
import com.xnyc.blog.po.TManagerDo;
import com.xnyc.blog.po.TMemberDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private XnycMapper dao;


    /**
     * 在请求被处理之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String opType = request.getParameter("opType");
        if (StringUtils.isEmpty(opType)) {
            response.sendRedirect("/");
            return false;
        }

        // 检查每个到来的请求对应的session域中是否有登录标识

        // TODO 这里要区分是用户还是管理人员，应该根据路径标识实现，
        Long loginId;
        if (Constant.OP_Type.USER.equals(opType)) {
            loginId = (Long)request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE.USER);
            TMemberDo userPo = dao.getMemberMapper().getByMemberId(loginId);
            if (userPo == null) {
                log.info("LoginInterceptor user NOt login.");
                // TODO: 重定向到用户登录界面
                response.sendRedirect("/");
                return false;
            }
        } else if (Constant.OP_Type.MANAGER.equals(opType)) {
            loginId = (Long)request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE.ADMIN);
            TManagerDo adminPo = dao.getManagerMapper().getByManagerId(loginId);
            if (adminPo == null) {
                log.info("LoginInterceptor admin NOt login.");
                // TODO: 重定向到管理员登录界面
                response.sendRedirect("/");
                return false;
            }
        }

        return true;
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
