package com.xnyc.blog.api.apientity;

import com.xnyc.blog.meta.IErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 郑杜
 * @date : 2019/08/11
 */
@Data
public class AbstractResponse {
    @ApiModelProperty(value = "错误码")
    private String resultCode = IErrorCode.SUCCESS;

    @ApiModelProperty(value = "错误描述")
    private String description = "success";
}
