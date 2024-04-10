package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.PrizeRecordExcel;
import com.yongoe.ecy.project.controller.vo.req.PrizeRecordReq;
import com.yongoe.ecy.project.controller.vo.res.PrizeRecordRes;
import com.yongoe.ecy.project.entity.PrizeRecord;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 奖品兑换记录 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface PrizeRecordConvert {
    /**
     * entity to vo
     */
    PrizeRecordReq entity2Req(PrizeRecord entity);

    PrizeRecordRes entity2Res(PrizeRecord entity);

    PrizeRecordExcel entity2Excel(PrizeRecord entity);

    /**
     * entity to vo List
     */
    List<PrizeRecordReq> entity2ReqList(List<PrizeRecord> list);

    List<PrizeRecordRes> entity2ResList(List<PrizeRecord> list);

    List<PrizeRecordExcel> entity2ExcelList(List<PrizeRecord> list);

    /**
     * entity to vo Page
     */
    Page<PrizeRecordRes> entity2ResPage(Page<PrizeRecord> page);

    /**
     * vo to entity
     */
    PrizeRecord req2Entity(PrizeRecordReq req);

    PrizeRecord excel2Entity(PrizeRecordExcel excel);

    /**
     * vo to entity List
     */
    List<PrizeRecord> excel2EntityList(List<PrizeRecordExcel> list);


}