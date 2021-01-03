package com.xnyc.blog.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 后台管理员Do
 *
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Data
public class TManagerDo {
    //主键
    private Long managerId;

    //管理模块Id，
    private Long manageModuleId;

    //登录名
    private String loginName;

    //密码
    private String password;

    //姓名
    private String name;

    //手机号码
    private String mobilePhone;

    //邮箱
    private String email;

    //过期时间
    private LocalDateTime expiredTime;

    //创建时间
    private LocalDateTime createTime;

    //最后修改时间
    private LocalDateTime lastModifyTime;
}
