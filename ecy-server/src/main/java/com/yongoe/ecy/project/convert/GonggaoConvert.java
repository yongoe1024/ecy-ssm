package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.GonggaoExcel;
import com.yongoe.ecy.project.controller.vo.req.GonggaoReq;
import com.yongoe.ecy.project.controller.vo.res.GonggaoRes;
import com.yongoe.ecy.project.entity.Gonggao;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 公告管理 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface GonggaoConvert {
    /**
     * entity to vo
     */
    GonggaoReq entity2Req(Gonggao entity);

    GonggaoRes entity2Res(Gonggao entity);

    GonggaoExcel entity2Excel(Gonggao entity);

    /**
     * entity to vo List
     */
    List<GonggaoReq> entity2ReqList(List<Gonggao> list);

    List<GonggaoRes> entity2ResList(List<Gonggao> list);

    List<GonggaoExcel> entity2ExcelList(List<Gonggao> list);

    /**
     * entity to vo Page
     */
    Page<GonggaoRes> entity2ResPage(Page<Gonggao> page);

    /**
     * vo to entity
     */
    Gonggao req2Entity(GonggaoReq req);

    Gonggao excel2Entity(GonggaoExcel excel);

    /**
     * vo to entity List
     */
    List<Gonggao> excel2EntityList(List<GonggaoExcel> list);


}