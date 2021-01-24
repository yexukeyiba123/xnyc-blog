package com.xnyc.blog.api.apientity.category;

import com.xnyc.blog.api.apientity.AbstractRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 郑杜
 * @date : 2021/01/24
 */
@Data
public class QueryCategoryByIdRequest extends AbstractRequest {
    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "是否查询子分类，true时代表查categoryId的下一级分类")
    private Boolean querySub = false;
}
