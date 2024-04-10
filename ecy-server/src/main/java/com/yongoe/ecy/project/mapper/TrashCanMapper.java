package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.TrashCan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 垃圾桶管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper
public interface TrashCanMapper extends BaseMapper<TrashCan> {

    Page<TrashCan> getTrashCanByPage(Page<TrashCan> page, @Param("trashCan") TrashCan trashCan);

}
