package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Goods;
import com.yongoe.ecy.project.mapper.GoodsMapper;
import com.yongoe.ecy.project.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 垃圾回收
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Override
    public Page<Goods> getGoodsByPage(Page<Goods> page, Goods goods) {
       return baseMapper.getGoodsByPage(page, goods);
    }

}
