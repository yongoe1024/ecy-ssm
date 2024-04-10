package com.yongoe.ecy.project.controller.vo.res;

import com.yongoe.ecy.project.entity.Message;
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
 * 留言管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRes {

    /**
     * 
     */
    private Long id;
    /**
     * pid
     */
    private Long parentId;
    /**
     * 留言内容
     */
    private String content;
    /**
     * 状态
     */
    private String status;
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

    private List<Message> children;

    private String avatar;

}