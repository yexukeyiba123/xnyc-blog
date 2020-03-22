package com.xnyc.blog.api.apientity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.xnyc.blog.meta.Constant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : 郑杜
 * @date : 2019/08/11
 */
@Data
public class AbstractRequest {
    @ApiModelProperty(value = "操作人员的Id")
    @NotBlank(message = "opId不能为空")
    private String opId;

    @ApiModelProperty(value = "操作人员的类型", allowableValues = Constant.OP_Type.SUMMARY)
    @NotBlank(message = "opType不能为空")
    private String opType;
}
