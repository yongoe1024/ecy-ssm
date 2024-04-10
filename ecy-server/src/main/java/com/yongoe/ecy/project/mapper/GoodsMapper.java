package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 垃圾回收
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    Page<Goods> getGoodsByPage(Page<Goods> page, @Param("goods") Goods goods);

}
