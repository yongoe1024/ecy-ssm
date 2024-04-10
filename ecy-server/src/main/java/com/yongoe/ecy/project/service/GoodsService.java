package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 垃圾回收
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface GoodsService extends IService<Goods> {

    Page<Goods> getGoodsByPage(Page<Goods> page, Goods goods);

}
