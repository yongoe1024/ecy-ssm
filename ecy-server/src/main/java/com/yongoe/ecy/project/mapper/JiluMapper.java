package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Jilu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 积分记录
 *
 * @author yongoe
 * @since 2024/03/24
 */
@Mapper
public interface JiluMapper extends BaseMapper<Jilu> {

    Page<Jilu> getJiluByPage(Page<Jilu> page, @Param("jilu") Jilu jilu);

}
