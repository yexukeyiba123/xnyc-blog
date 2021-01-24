package com.xnyc.blog.api.controller;

import com.xnyc.blog.api.apientity.AbstractResponse;
import com.xnyc.blog.api.apientity.category.DeleteCategoryByIdRequest;
import com.xnyc.blog.api.apientity.category.QueryCategoryByIdRequest;
import com.xnyc.blog.api.apientity.category.QueryCategoryByIdResponse;
import com.xnyc.blog.application.category.DeleteCategoryApp;
import com.xnyc.blog.application.category.QueryCategoryApp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Slf4j
@RestController
@RequestMapping("/category")
@Api(tags = "文章分类接口")
public class CategoryController {
    @Autowired
    private QueryCategoryApp queryCategoryApp;

    @Autowired
    private DeleteCategoryApp deleteCategoryApp;

    @ApiOperation(value = "查询指定分类", notes = "")
    @PostMapping("/query/by_id")
    public QueryCategoryByIdResponse getUserById(@RequestBody @Valid QueryCategoryByIdRequest req) {
        return queryCategoryApp.queyById(req);
    }

    @ApiOperation(value = "删除指定分类", notes = "")
    @PostMapping("/delete/by_id")
    public AbstractResponse getUserById(@RequestBody @Valid DeleteCategoryByIdRequest req) {
        return deleteCategoryApp.deleteById(req);
    }


}
