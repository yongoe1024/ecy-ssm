package com.yongoe.ecy.project.controller.vo.res;

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
 * 垃圾投放
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RubbishRes {

    /**
     * 
     */
    private Long id;
    /**
     * 状态
     */
    private String status;
    /**
     * 图片
     */
    private String img;
    /**
     * 详情
     */
    private String detials;
    /**
     * 垃圾桶
     */
    private String trashCan;
    /**
     * 垃圾桶类型
     */
    private String trashCanType;
    /**
     * 垃圾桶地点
     */
    private String trashCanAddress;
    /**
     * 投放时间
     */
    private String putTime;
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