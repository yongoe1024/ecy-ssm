package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Rubbish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 垃圾投放
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper
public interface RubbishMapper extends BaseMapper<Rubbish> {

    Page<Rubbish> getRubbishByPage(Page<Rubbish> page, @Param("rubbish") Rubbish rubbish);

}
