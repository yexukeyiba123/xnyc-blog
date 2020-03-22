package com.xnyc.blog.api.controller;

import com.xnyc.blog.api.apientity.AbstractRequest;
import com.xnyc.blog.api.apientity.user.QueryUserRequest;
import com.xnyc.blog.domain.exception.ServiceException;
import com.xnyc.blog.mapper.TUserDao;
import com.xnyc.blog.po.TUserPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author : 郑杜
 * @date : 2019/08/10
 */
@Slf4j
@RestController
@RequestMapping("/query")
@Api(tags = "查询接口")
public class QueryController {

    @Autowired
    private TUserDao userDao;

    @ApiOperation(value = "查询用户", notes = "")
    @PostMapping("/by_id")
    public TUserPo getUserById(@RequestBody @Valid QueryUserRequest req) {
        return userDao.getByUserId(req.getUserId());
    }

    @PostMapping("/all")
    public List<TUserPo> getAllUser() {
        log.info("== begin to get all user.");
        return userDao.getAllUser();
    }

}
