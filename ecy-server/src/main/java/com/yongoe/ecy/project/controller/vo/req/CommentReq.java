package com.yongoe.ecy.project.controller.vo.req;

import com.yongoe.ecy.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.time.LocalDateTime;

/**
 * 留言评论
 *
 * @author yongoe
 * @since 2024/04/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentReq  extends BaseEntity {

    /**
     * 
     */
    private Long id;
    private Long parentId;

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