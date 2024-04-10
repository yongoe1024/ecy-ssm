package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.PrizeRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 奖品兑换记录
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface PrizeRecordService extends IService<PrizeRecord> {

    Page<PrizeRecord> getPrizeRecordByPage(Page<PrizeRecord> page, PrizeRecord prizeRecord);

}
