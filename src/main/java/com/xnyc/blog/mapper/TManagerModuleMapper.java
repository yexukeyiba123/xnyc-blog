package com.xnyc.blog.mapper;

import com.xnyc.blog.po.TManagerDo;
import com.xnyc.blog.po.TManagerModuleDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Mapper
public interface TManagerModuleMapper {

    TManagerModuleDo getByManageModuleId(String manageModuleId);

}
