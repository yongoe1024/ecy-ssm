package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.PrizeRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 奖品兑换记录
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper
public interface PrizeRecordMapper extends BaseMapper<PrizeRecord> {

    Page<PrizeRecord> getPrizeRecordByPage(Page<PrizeRecord> page, @Param("prizeRecord") PrizeRecord prizeRecord);

}
