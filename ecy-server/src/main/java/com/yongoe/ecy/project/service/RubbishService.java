package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Rubbish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 垃圾投放
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface RubbishService extends IService<Rubbish> {

    Page<Rubbish> getRubbishByPage(Page<Rubbish> page, Rubbish rubbish);

}
