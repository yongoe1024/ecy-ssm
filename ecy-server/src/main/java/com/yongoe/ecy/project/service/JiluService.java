package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Jilu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 积分记录
 *
 * @author yongoe
 * @since 2024/03/24
 */
public interface JiluService extends IService<Jilu> {

    Page<Jilu> getJiluByPage(Page<Jilu> page, Jilu jilu);

    void updateScore(String name, Integer score,String from);


}
