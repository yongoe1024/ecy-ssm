package com.yongoe.ecy.project.controller.vo.res;

import com.yongoe.ecy.project.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 留言评论
 *
 * @author yongoe
 * @since 2024/04/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRes {

    /**
     * 
     */
    private Long id;
    private Long parentId;
    private String avatar;
    private List<Comment> children;

    /**
     * 表名
     */
    private String table;
    /**
     * 类型1留言2评论
     */
    private String type;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态
     */
    private String status;
    /**
     * 参数
     */
    private String param;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改人
     */
    private String updateBy;
}