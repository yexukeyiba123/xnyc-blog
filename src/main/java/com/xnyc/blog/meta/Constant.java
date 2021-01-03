package com.xnyc.blog.meta;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
public interface Constant {
    /**
     * 会话标识：用于登录使用
     */
    interface  SESSION_ATTRIBUTE {
        String USER = "loginUserId";

        String ADMIN = "loginAdminId";
    }

    /**
     * 操作类型
     */
    interface OP_Type {
        // 用户
        String USER = "USER";

        // 后台管理员
        String MANAGER = "MANAGER";

        // 系统
        String SYSTEM = "SYSTEM";

        String SUMMARY = "USER:用户,MANAGER:后台管理员,SYSTEM:系统";
    }

}
