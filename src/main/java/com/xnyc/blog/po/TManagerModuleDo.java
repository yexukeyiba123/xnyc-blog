package com.xnyc.blog.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *  后台管理模块
 *
 * @author : 郑杜
 * @date : 2020/12/27
 */
@Data
public class TManagerModuleDo {
    //主键
    private Long manageModuleId;

    //模块名
    private String moduleName;

    //模块url
    private String modulUrl;

    //创建时间
    private LocalDateTime createTime;

    //最后修改时间
    private LocalDateTime lastModifyTime;
}
