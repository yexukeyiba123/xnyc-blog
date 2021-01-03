package com.xnyc.blog.api.controller;

import com.xnyc.blog.api.apientity.login.LoginRequest;
import com.xnyc.blog.api.apientity.login.LoginResponse;
import com.xnyc.blog.domain.exception.ServiceException;
import com.xnyc.blog.mapper.XnycMapper;
import com.xnyc.blog.meta.ResultCode;
import com.xnyc.blog.po.TManagerDo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 管理员相关接口
 *
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Slf4j
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private XnycMapper xnycMapper;

    @ApiOperation(value = "登录校验")
    @PostMapping("/login")
    public LoginResponse login(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid LoginRequest req) throws IOException {
        log.info("dddss:" + req + req.getOpId() + req.getOpType());

        if (StringUtils.isEmpty(req.getLoginName()) || StringUtils.isEmpty(req.getPassword())) {
            throw new ServiceException(ResultCode.ERROR_PARAM, "用户名或密码为空");
        }

        TManagerDo managerDo = xnycMapper.getManagerMapper().getByLoginName(req.getLoginName());
        if (managerDo == null) {
            throw new ServiceException(ResultCode.ERROR_PARAM, "用户名不存在");
        }

        if (!req.getPassword().equals(managerDo.getPassword())) {
            throw new ServiceException(ResultCode.ERROR_PARAM, "密码不正确");
        }

        if (managerDo.getExpiredTime() == null ||
                managerDo.getExpiredTime().compareTo(LocalDateTime.now()) <= 0) {
            throw new ServiceException(ResultCode.ERROR_PARAM, "账号过期");
        }

        // 校验通过时，在session里放入一个标识
        // 后续通过session里是否存在该标识来判断用户是否登录
        request.getSession().setAttribute("loginName", "admin");

        return new LoginResponse();
    }

    @ApiOperation(value = "注销登录")
    @PostMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

}