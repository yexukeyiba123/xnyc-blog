package com.xnyc.blog.mapper;

import com.xnyc.blog.po.TArticleCategoryDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 郑杜
 * @date : 2021/01/24
 */
@Mapper
public interface TArticleCategoryMapper {
    List<TArticleCategoryDo> getSubCategoryListById(@Param("parentCategoryId") Long parentCategoryId);

    List<TArticleCategoryDo> getCategoryListById(Long categoryId);

    int deleteById(Long categoryId);
}
