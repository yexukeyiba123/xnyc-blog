package com.xnyc.blog.application.category;

import com.xnyc.blog.api.apientity.category.CategoryDetail;
import com.xnyc.blog.api.apientity.category.QueryCategoryByIdRequest;
import com.xnyc.blog.api.apientity.category.QueryCategoryByIdResponse;
import com.xnyc.blog.domain.exception.ServiceException;
import com.xnyc.blog.mapper.XnycMapper;
import com.xnyc.blog.meta.ResultCode;
import com.xnyc.blog.po.TArticleCategoryDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询分类
 *
 * @author : 郑杜
 * @date : 2021/01/24
 */
@Service
public class QueryCategoryApp {
    @Autowired
    private XnycMapper xnycMapper;
    
    public QueryCategoryByIdResponse queyById(QueryCategoryByIdRequest req) {
        //查询具体分类是，分类id不能为空
        if (!req.getQuerySub() && req.getCategoryId() == null) {
            throw new ServiceException(ResultCode.ERROR_PARAM, "categoryId不能为空");
        }

        List<TArticleCategoryDo> categoryList;
        if (req.getQuerySub()) {
            categoryList = xnycMapper.getCategoryMapper().getSubCategoryListById(req.getCategoryId());
        } else {
            categoryList = xnycMapper.getCategoryMapper().getCategoryListById(req.getCategoryId());
        }

        if (CollectionUtils.isEmpty(categoryList)) {
            return new QueryCategoryByIdResponse();
        }

        QueryCategoryByIdResponse resp = new QueryCategoryByIdResponse();
        List<CategoryDetail> detailList = new ArrayList<>();
        for (TArticleCategoryDo categoryDo : categoryList) {
            CategoryDetail detail = new CategoryDetail();
            detail.setCategoryId(categoryDo.getCategoryId());
            detail.setParentCategoryId(categoryDo.getParentCategoryId());
            detail.setCategoryLevel(categoryDo.getCategoryLevel());
            detail.setCategoryName(categoryDo.getCategoryName());
            detail.setCreateTime(categoryDo.getCreateTime());
            detail.setLastModifyTime(categoryDo.getLastModifyTime());
            detail.setStatus(categoryDo.getStatus());
            detailList.add(detail);
        }
        resp.setCategoryList(detailList);
        return resp;
    }
}
