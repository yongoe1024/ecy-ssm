package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.TrashCan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 垃圾桶管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface TrashCanService extends IService<TrashCan> {

    Page<TrashCan> getTrashCanByPage(Page<TrashCan> page, TrashCan trashCan);

}
