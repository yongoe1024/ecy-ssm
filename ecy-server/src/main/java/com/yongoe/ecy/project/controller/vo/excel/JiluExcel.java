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
 * 积分记录
 *
 * @author yongoe
 * @since 2024/03/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JiluExcel {

    private Long id;

    @Excel(name = "用户id", width = 20)
    private Long userId;

    @Excel(name = "原因", width = 20)
    private String detail;

    @Excel(name = "变化数量", width = 20)
    private Integer updateNum;

    @Excel(name = "当前总数", width = 20)
    private Integer sum;

    @Excel(name = "创建时间", width = 20)
    private LocalDateTime createTime;

    @Excel(name = "修改时间", width = 20)
    private LocalDateTime updateTime;

    @Excel(name = "创建人", width = 20)
    private String createBy;

    @Excel(name = "修改人", width = 20)
    private String updateBy;

}