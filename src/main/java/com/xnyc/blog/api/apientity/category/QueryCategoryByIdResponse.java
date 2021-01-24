package com.xnyc.blog.api.apientity.category;

import com.xnyc.blog.api.apientity.AbstractResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : 郑杜
 * @date : 2021/01/24
 */
@Data
public class QueryCategoryByIdResponse extends AbstractResponse {
    @ApiModelProperty(value = "分类列表")
    public List<CategoryDetail> categoryList;
}
