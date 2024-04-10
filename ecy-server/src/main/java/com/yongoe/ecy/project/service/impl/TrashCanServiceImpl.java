package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.TrashCan;
import com.yongoe.ecy.project.mapper.TrashCanMapper;
import com.yongoe.ecy.project.service.TrashCanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 垃圾桶管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class TrashCanServiceImpl extends ServiceImpl<TrashCanMapper, TrashCan> implements TrashCanService {

    @Override
    public Page<TrashCan> getTrashCanByPage(Page<TrashCan> page, TrashCan trashCan) {
       return baseMapper.getTrashCanByPage(page, trashCan);
    }

}
