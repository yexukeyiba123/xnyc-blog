package com.xnyc.blog.api.apientity.manager;

import com.xnyc.blog.api.apientity.AbstractRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录请求体
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Data
public class LoginRequest extends AbstractRequest {

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String loginName;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
