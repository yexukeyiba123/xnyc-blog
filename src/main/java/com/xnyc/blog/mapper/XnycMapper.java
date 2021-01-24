package com.xnyc.blog.mapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : 郑杜
 * @date : 2020/03/22
 */
@Component
@Data
public class XnycMapper {
    @Autowired
    private TMemberMapper memberMapper;

    @Autowired
    private TManagerMapper managerMapper;

    @Autowired
    private TManagerModuleMapper managerModuleMapper;

    @Autowired
    private TArticleCategoryMapper categoryMapper;
}
