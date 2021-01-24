package com.xnyc.blog.api.apientity.category;

import com.xnyc.blog.api.apientity.AbstractRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : 郑杜
 * @date : 2021/01/24
 */
@Data
public class DeleteCategoryByIdRequest extends AbstractRequest {
    @NotNull
    @ApiModelProperty(value = "分类id")
    private Long categoryId;
}
