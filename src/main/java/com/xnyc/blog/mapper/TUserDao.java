package com.xnyc.blog.mapper;

import com.xnyc.blog.po.TUserPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Mapper
public interface TUserDao {

    TUserPo getByUserId(String userId);

    int updateByUserId(TUserPo userPo);

    List<TUserPo> getAllUser();

}
