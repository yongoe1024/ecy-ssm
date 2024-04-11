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
 * 留言评论
 *
 * @author yongoe
 * @since 2024/04/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentExcel {

    private Long id;

    @Excel(name = "表名", width = 20)
    private String table;

    @Excel(name = "类型1留言2评论", width = 20)
    private String type;

    @Excel(name = "内容", width = 20)
    private String content;

    @Excel(name = "状态", width = 20)
    private String status;

    @Excel(name = "参数", width = 20)
    private String param;

    @Excel(name = "创建时间", width = 20)
    private LocalDateTime createTime;

    @Excel(name = "修改时间", width = 20)
    private LocalDateTime updateTime;

    @Excel(name = "创建人", width = 20)
    private String createBy;

    @Excel(name = "修改人", width = 20)
    private String updateBy;

}