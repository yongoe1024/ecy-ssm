package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Gonggao;
import com.yongoe.ecy.project.mapper.GonggaoMapper;
import com.yongoe.ecy.project.service.GonggaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class GonggaoServiceImpl extends ServiceImpl<GonggaoMapper, Gonggao> implements GonggaoService {

    @Override
    public Page<Gonggao> getGonggaoByPage(Page<Gonggao> page, Gonggao gonggao) {
       return baseMapper.getGonggaoByPage(page, gonggao);
    }

}
