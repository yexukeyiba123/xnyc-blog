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
 * 用户相关接口
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

}