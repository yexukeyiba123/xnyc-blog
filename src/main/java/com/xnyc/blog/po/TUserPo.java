package com.xnyc.blog.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Data
public class TUserPo {
    //主键
    private Long id;

    //用户Id，唯一标识用户
    private String userId;

    //用户名
    private String userName;

    //登录名
    private String loginName;

    //密码
    private String password;

    //姓名
    private String name;

    //年龄
    private Integer age;

    //性别
    private String sex;

    //手机号码
    private String mobilePhone;

    //邮箱
    private String email;

    //最后修改时间
    private LocalDateTime lastModifyTime;

    //创建时间
    private LocalDateTime createTime;
}
