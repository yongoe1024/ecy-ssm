package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Gonggao;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 公告管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface GonggaoService extends IService<Gonggao> {

    Page<Gonggao> getGonggaoByPage(Page<Gonggao> page, Gonggao gonggao);

}
