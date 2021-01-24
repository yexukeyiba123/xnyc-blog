package com.xnyc.blog.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章Do
 *
 * @author : 郑杜
 * @date : 2021/01/17
 */
@Data
public class TArticleDo {
    //主键，文章id
    private Long articleId;

    //该文章的分类
    private Long categoryId;

    //文章标题
    private String title;

    //文章内容
    private String content;

    //文章的浏览量
    private Long viewNum;

    //点赞数量
    private Long goodNum;

    //一般般数量
    private Long soSoNum;

    //踩数量
    private Long badNum;

    //该文章的状态
    private String status;

    //管理员Id
    private Long managerId;

    //最后修改的管理员Id
    private LocalDateTime lastModifyManagerId;

    //创建时间
    private LocalDateTime createTime;

    //最后修改时间
    private LocalDateTime lastModifyTime;
}
