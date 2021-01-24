package com.xnyc.blog.application.category;

import com.xnyc.blog.api.apientity.AbstractResponse;
import com.xnyc.blog.api.apientity.category.DeleteCategoryByIdRequest;
import com.xnyc.blog.domain.exception.ServiceException;
import com.xnyc.blog.mapper.XnycMapper;
import com.xnyc.blog.meta.ResultCode;
import com.xnyc.blog.po.TArticleCategoryDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 删除分类
 *
 * @author : 郑杜
 * @date : 2021/01/24
 */
@Service
public class DeleteCategoryApp {
    @Autowired
    private XnycMapper xnycMapper;

    public AbstractResponse deleteById(DeleteCategoryByIdRequest req) {
        List<TArticleCategoryDo> categoryList = xnycMapper.getCategoryMapper().getSubCategoryListById(req.getCategoryId());
        if (!CollectionUtils.isEmpty(categoryList)) {
            throw new ServiceException(ResultCode.ERROR_PARAM, "该分类还有对应的子分类，不能删除。");
        }

        //todo 该分类还有对应的文章，不能删除。

        xnycMapper.getCategoryMapper().deleteById(req.getCategoryId());
        return new AbstractResponse();
    }
}
