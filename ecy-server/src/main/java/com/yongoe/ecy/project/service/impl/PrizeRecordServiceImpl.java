package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.PrizeRecord;
import com.yongoe.ecy.project.mapper.PrizeRecordMapper;
import com.yongoe.ecy.project.service.PrizeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 奖品兑换记录
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class PrizeRecordServiceImpl extends ServiceImpl<PrizeRecordMapper, PrizeRecord> implements PrizeRecordService {

    @Override
    public Page<PrizeRecord> getPrizeRecordByPage(Page<PrizeRecord> page, PrizeRecord prizeRecord) {
       return baseMapper.getPrizeRecordByPage(page, prizeRecord);
    }

}
