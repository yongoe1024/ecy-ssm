package com.yongoe.ecy.project.controller.vo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
public class GoodsExcel {

    private Long id;

    @Excel(name = "名称", width = 20)
    private String name;

    @Excel(name = "图片", width = 20)
    private String img;

    @Excel(name = "详情", width = 20)
    private String detials;

    @Excel(name = "价格", width = 20)
    private String price;

    @Excel(name = "交易地点", width = 20)
    private String address;

    @Excel(name = "联系方式", width = 20)
    private String phone;

    @Excel(name = "买家姓名", width = 20)
    private String buyer;

    @Excel(name = "买家联系方式", width = 20)
    private String buyerPhone;

    @Excel(name = "购买时间", width = 20)
    private LocalDateTime buyTime;

    @Excel(name = "状态", width = 20)
    private String status;

    @Excel(name = "创建时间", width = 20)
    private LocalDateTime createTime;

    @Excel(name = "修改时间", width = 20)
    private LocalDateTime updateTime;

    @Excel(name = "创建人", width = 20)
    private String createBy;

    @Excel(name = "修改人", width = 20)
    private String updateBy;

}