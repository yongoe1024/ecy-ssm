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
 * 垃圾回收
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsRes {

    /**
     * 
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String img;
    /**
     * 详情
     */
    private String detials;
    /**
     * 价格
     */
    private String price;
    /**
     * 交易地点
     */
    private String address;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 买家姓名
     */
    private String buyer;
    /**
     * 买家联系方式
     */
    private String buyerPhone;
    /**
     * 购买时间
     */
    private LocalDateTime buyTime;
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
}