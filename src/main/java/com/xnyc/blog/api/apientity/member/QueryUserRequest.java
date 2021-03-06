package com.xnyc.blog.api.apientity.member;

import com.xnyc.blog.api.apientity.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class QueryUserRequest extends AbstractRequest {
    @ApiModelProperty(value = "用户Id")
    @NotNull
    private Long memberId;
}
