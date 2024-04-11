package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Comment;
import com.yongoe.ecy.project.mapper.CommentMapper;
import com.yongoe.ecy.project.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言评论
 *
 * @author yongoe
 * @since 2024/04/11
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public Page<Comment> getCommentByPage(Page<Comment> page, Comment comment) {
       return baseMapper.getCommentByPage(page, comment);
    }

}
