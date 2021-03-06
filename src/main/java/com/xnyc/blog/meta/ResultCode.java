package com.xnyc.blog.meta;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
public interface ResultCode {
    // 成功
    String SUCCESS = "0";

    // 未知错误
    String UNKNOWN_ERROR = "5000";

    // 参数错误
    String ERROR_PARAM = "5001";

    // 没有登录
    String NO_LOGIN = "5002";

}
