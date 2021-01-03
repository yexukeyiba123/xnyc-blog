package com.xnyc.blog.api.controller;

import com.xnyc.blog.api.apientity.user.QueryUserRequest;
import com.xnyc.blog.mapper.TMemberMapper;
import com.xnyc.blog.po.TMemberDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
    private TMemberMapper memberDao;

    @ApiOperation(value = "查询用户", notes = "")
    @PostMapping("/by_id")
    public TMemberDo getUserById(@RequestBody @Valid QueryUserRequest req) {
        return memberDao.getByMemberId(req.getMemberId());
    }

    @PostMapping("/all")
    public List<TMemberDo> getAllUser() {
        log.info("== begin to get all user.");
        return memberDao.getAllMember();
    }

}
