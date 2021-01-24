package com.xnyc.blog.api.apientity.manager;

import com.xnyc.blog.api.apientity.AbstractResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录响应体
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Data
public class LoginResponse extends AbstractResponse {
    @ApiModelProperty(value = "管理员Id")
    private Long managerId;
}
