package com.xnyc.blog.mapper;

import com.xnyc.blog.po.TManagerDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Mapper
public interface TManagerMapper {

    TManagerDo getByLoginName(String loginName);

    TManagerDo getByManagerId(Long loginName);

}
