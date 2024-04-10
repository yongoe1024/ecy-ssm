package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Prize;
import com.yongoe.ecy.project.mapper.PrizeMapper;
import com.yongoe.ecy.project.service.PrizeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 奖品管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class PrizeServiceImpl extends ServiceImpl<PrizeMapper, Prize> implements PrizeService {

    @Override
    public Page<Prize> getPrizeByPage(Page<Prize> page, Prize prize) {
       return baseMapper.getPrizeByPage(page, prize);
    }

}
