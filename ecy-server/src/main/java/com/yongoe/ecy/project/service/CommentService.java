package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 留言评论
 *
 * @author yongoe
 * @since 2024/04/11
 */
public interface CommentService extends IService<Comment> {

    Page<Comment> getCommentByPage(Page<Comment> page, Comment comment);

}
