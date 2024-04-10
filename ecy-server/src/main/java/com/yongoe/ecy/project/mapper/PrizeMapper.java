package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Prize;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 奖品管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper
public interface PrizeMapper extends BaseMapper<Prize> {

    Page<Prize> getPrizeByPage(Page<Prize> page, @Param("prize") Prize prize);

}
