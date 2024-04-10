package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Gonggao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 公告管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper
public interface GonggaoMapper extends BaseMapper<Gonggao> {

    Page<Gonggao> getGonggaoByPage(Page<Gonggao> page, @Param("gonggao") Gonggao gonggao);

}
