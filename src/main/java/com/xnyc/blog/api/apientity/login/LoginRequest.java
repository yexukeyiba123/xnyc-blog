package com.xnyc.blog.api.apientity.login;

import com.xnyc.blog.api.apientity.AbstractRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录请求体
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Data
public class LoginRequest extends AbstractRequest {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
