package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.PrizeExcel;
import com.yongoe.ecy.project.controller.vo.req.PrizeReq;
import com.yongoe.ecy.project.controller.vo.res.PrizeRes;
import com.yongoe.ecy.project.entity.Prize;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 奖品管理 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface PrizeConvert {
    /**
     * entity to vo
     */
    PrizeReq entity2Req(Prize entity);

    PrizeRes entity2Res(Prize entity);

    PrizeExcel entity2Excel(Prize entity);

    /**
     * entity to vo List
     */
    List<PrizeReq> entity2ReqList(List<Prize> list);

    List<PrizeRes> entity2ResList(List<Prize> list);

    List<PrizeExcel> entity2ExcelList(List<Prize> list);

    /**
     * entity to vo Page
     */
    Page<PrizeRes> entity2ResPage(Page<Prize> page);

    /**
     * vo to entity
     */
    Prize req2Entity(PrizeReq req);

    Prize excel2Entity(PrizeExcel excel);

    /**
     * vo to entity List
     */
    List<Prize> excel2EntityList(List<PrizeExcel> list);


}