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
 * 垃圾投放
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RubbishExcel {

    private Long id;

    @Excel(name = "状态", width = 20)
    private String status;

    @Excel(name = "图片", width = 20)
    private String img;

    @Excel(name = "详情", width = 20)
    private String detials;

    @Excel(name = "垃圾桶", width = 20)
    private String trashCan;

    @Excel(name = "垃圾桶类型", width = 20)
    private String trashCanType;

    @Excel(name = "垃圾桶地点", width = 20)
    private String trashCanAddress;

    @Excel(name = "投放时间", width = 20)
    private String putTime;

    @Excel(name = "创建时间", width = 20)
    private LocalDateTime createTime;

    @Excel(name = "修改时间", width = 20)
    private LocalDateTime updateTime;

    @Excel(name = "创建人", width = 20)
    private String createBy;

    @Excel(name = "修改人", width = 20)
    private String updateBy;

}