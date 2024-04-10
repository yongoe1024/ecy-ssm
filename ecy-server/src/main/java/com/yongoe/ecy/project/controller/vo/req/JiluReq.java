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
 * 积分记录
 *
 * @author yongoe
 * @since 2024/03/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JiluReq  extends BaseEntity {

    /**
     * 
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 原因
     */
    private String detail;
    /**
     * 变化数量
     */
    private Integer updateNum;
    /**
     * 当前总数
     */
    private Integer sum;
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