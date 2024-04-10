package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Rubbish;
import com.yongoe.ecy.project.mapper.RubbishMapper;
import com.yongoe.ecy.project.service.RubbishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 垃圾投放
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class RubbishServiceImpl extends ServiceImpl<RubbishMapper, Rubbish> implements RubbishService {

    @Override
    public Page<Rubbish> getRubbishByPage(Page<Rubbish> page, Rubbish rubbish) {
       return baseMapper.getRubbishByPage(page, rubbish);
    }

}
