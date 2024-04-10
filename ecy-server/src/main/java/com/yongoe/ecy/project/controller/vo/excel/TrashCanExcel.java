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
 * 垃圾桶管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrashCanExcel {

    private Long id;

    @Excel(name = "名称", width = 20)
    private String name;

    @Excel(name = "类型", width = 20)
    private String type;

    @Excel(name = "容量", width = 20)
    private String capacity;

    @Excel(name = "图片", width = 20)
    private String img;

    @Excel(name = "可用", width = 20)
    private Byte enabled;

    @Excel(name = "位置", width = 20)
    private String address;

    @Excel(name = "创建时间", width = 20)
    private LocalDateTime createTime;

    @Excel(name = "修改时间", width = 20)
    private LocalDateTime updateTime;

    @Excel(name = "创建人", width = 20)
    private String createBy;

    @Excel(name = "修改人", width = 20)
    private String updateBy;

}