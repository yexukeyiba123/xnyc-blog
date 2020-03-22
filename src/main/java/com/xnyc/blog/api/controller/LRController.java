package com.xnyc.blog.api.controller;

import com.xnyc.blog.api.apientity.login.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * 登录和注册相关接口
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Slf4j
@RestController
@RequestMapping("/login_register")
public class LRController {

    // 预先设置好的正确的用户名和密码，用于登录验证
    private String rightUserName = "admin";
    private String rightPassword = "admin";

    /**
     * 登录校验
     *
     * @param request
     * @return
     */
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid LoginRequest loginReq) throws IOException {
        log.info("dddss:" + loginReq+ loginReq.getOpId()+ loginReq.getOpType());

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.sendRedirect("/");
        if (null == username || null == password) {
            return "redirect:/";
        }

        // 前端传回的密码实际为用户输入的：用户名（小写）+ 密码（小写）组合的字符串生成的md5值
        // 此处先通过后台保存的正确的用户名和密码计算出正确的md5值，然后和前端传回来的作比较
        String md5info = rightUserName.toLowerCase() + rightPassword.toLowerCase();
        String realPassword = DigestUtils.md5DigestAsHex(md5info.getBytes());
        if (!password.equals(realPassword)) {
            return "redirect:/";
        }

        // 校验通过时，在session里放入一个标识
        // 后续通过session里是否存在该标识来判断用户是否登录
        request.getSession().setAttribute("loginName", "admin");
        return "redirect:/welcome";
    }

    /**
     * 注销登录
     *
     * @param request
     * @return
     */
    @PostMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

}