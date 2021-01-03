package com.xnyc.blog.mapper;

import com.xnyc.blog.po.TManagerDo;
import com.xnyc.blog.po.TMemberDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Mapper
public interface TMemberMapper {

    TMemberDo getByMemberId(Long managerId);

    int updateByMemberId(TMemberDo memberDo);

    List<TMemberDo> getAllMember();

}
