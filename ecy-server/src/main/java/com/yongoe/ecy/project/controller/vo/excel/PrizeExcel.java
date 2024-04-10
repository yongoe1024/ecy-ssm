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
 * 奖品管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrizeExcel {

    private Long id;

    @Excel(name = "名称", width = 20)
    private String name;

    @Excel(name = "图片", width = 20)
    private String img;

    @Excel(name = "详情", width = 20)
    private String detials;

    @Excel(name = "积分", width = 20)
    private String score;

    @Excel(name = "数量", width = 20)
    private Integer num;

    @Excel(name = "创建时间", width = 20)
    private LocalDateTime createTime;

    @Excel(name = "修改时间", width = 20)
    private LocalDateTime updateTime;

    @Excel(name = "创建人", width = 20)
    private String createBy;

    @Excel(name = "修改人", width = 20)
    private String updateBy;

}