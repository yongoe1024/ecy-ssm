package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Prize;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 奖品管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface PrizeService extends IService<Prize> {

    Page<Prize> getPrizeByPage(Page<Prize> page, Prize prize);

}
