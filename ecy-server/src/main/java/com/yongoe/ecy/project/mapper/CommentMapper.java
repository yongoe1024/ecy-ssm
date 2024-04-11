package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 留言评论
 *
 * @author yongoe
 * @since 2024/04/11
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    Page<Comment> getCommentByPage(Page<Comment> page, @Param("comment") Comment comment);

}
