package com.xnyc.blog.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章分类Do
 *
 * @author : 郑杜
 * @date : 2021/01/17
 */
@Data
public class TArticleCategoryDo {
    //主键，分类Id
    private Long categoryId;

    //父分类Id
    private Long parentCategoryId;

    //分类级别，0级是最顶级，依次往后1
    private Integer categoryLevel;

    //分类中文名
    private String categoryName;

    //该分类的状态
    private String status;

    //创建时间
    private LocalDateTime createTime;

    //最后修改时间
    private LocalDateTime lastModifyTime;
}
