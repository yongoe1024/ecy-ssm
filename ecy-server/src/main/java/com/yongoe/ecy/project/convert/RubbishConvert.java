package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.RubbishExcel;
import com.yongoe.ecy.project.controller.vo.req.RubbishReq;
import com.yongoe.ecy.project.controller.vo.res.RubbishRes;
import com.yongoe.ecy.project.entity.Rubbish;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 垃圾投放 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface RubbishConvert {
    /**
     * entity to vo
     */
    RubbishReq entity2Req(Rubbish entity);

    RubbishRes entity2Res(Rubbish entity);

    RubbishExcel entity2Excel(Rubbish entity);

    /**
     * entity to vo List
     */
    List<RubbishReq> entity2ReqList(List<Rubbish> list);

    List<RubbishRes> entity2ResList(List<Rubbish> list);

    List<RubbishExcel> entity2ExcelList(List<Rubbish> list);

    /**
     * entity to vo Page
     */
    Page<RubbishRes> entity2ResPage(Page<Rubbish> page);

    /**
     * vo to entity
     */
    Rubbish req2Entity(RubbishReq req);

    Rubbish excel2Entity(RubbishExcel excel);

    /**
     * vo to entity List
     */
    List<Rubbish> excel2EntityList(List<RubbishExcel> list);


}