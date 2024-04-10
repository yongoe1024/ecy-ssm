package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.TrashCanExcel;
import com.yongoe.ecy.project.controller.vo.req.TrashCanReq;
import com.yongoe.ecy.project.controller.vo.res.TrashCanRes;
import com.yongoe.ecy.project.entity.TrashCan;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 垃圾桶管理 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface TrashCanConvert {
    /**
     * entity to vo
     */
    TrashCanReq entity2Req(TrashCan entity);

    TrashCanRes entity2Res(TrashCan entity);

    TrashCanExcel entity2Excel(TrashCan entity);

    /**
     * entity to vo List
     */
    List<TrashCanReq> entity2ReqList(List<TrashCan> list);

    List<TrashCanRes> entity2ResList(List<TrashCan> list);

    List<TrashCanExcel> entity2ExcelList(List<TrashCan> list);

    /**
     * entity to vo Page
     */
    Page<TrashCanRes> entity2ResPage(Page<TrashCan> page);

    /**
     * vo to entity
     */
    TrashCan req2Entity(TrashCanReq req);

    TrashCan excel2Entity(TrashCanExcel excel);

    /**
     * vo to entity List
     */
    List<TrashCan> excel2EntityList(List<TrashCanExcel> list);


}