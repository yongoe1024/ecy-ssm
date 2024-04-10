package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.GoodsExcel;
import com.yongoe.ecy.project.controller.vo.req.GoodsReq;
import com.yongoe.ecy.project.controller.vo.res.GoodsRes;
import com.yongoe.ecy.project.entity.Goods;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 垃圾回收 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface GoodsConvert {
    /**
     * entity to vo
     */
    GoodsReq entity2Req(Goods entity);

    GoodsRes entity2Res(Goods entity);

    GoodsExcel entity2Excel(Goods entity);

    /**
     * entity to vo List
     */
    List<GoodsReq> entity2ReqList(List<Goods> list);

    List<GoodsRes> entity2ResList(List<Goods> list);

    List<GoodsExcel> entity2ExcelList(List<Goods> list);

    /**
     * entity to vo Page
     */
    Page<GoodsRes> entity2ResPage(Page<Goods> page);

    /**
     * vo to entity
     */
    Goods req2Entity(GoodsReq req);

    Goods excel2Entity(GoodsExcel excel);

    /**
     * vo to entity List
     */
    List<Goods> excel2EntityList(List<GoodsExcel> list);


}