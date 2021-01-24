package com.xnyc.blog.api.apientity.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : 郑杜
 * @date : 2021/01/24
 */
@Data
public class CategoryDetail {
    @ApiModelProperty(value = "分类Id")
    private Long categoryId;

    @ApiModelProperty(value = "父分类Id")
    private Long parentCategoryId;

    @ApiModelProperty(value = "分类级别，0级是最顶级，依次往后1")
    private Integer categoryLevel;

    @ApiModelProperty(value = "分类中文名")
    private String categoryName;

    @ApiModelProperty(value = "该分类的状态：1：启用，0：停用")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime lastModifyTime;
}
