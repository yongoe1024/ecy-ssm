package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.JiluExcel;
import com.yongoe.ecy.project.controller.vo.req.JiluReq;
import com.yongoe.ecy.project.controller.vo.res.JiluRes;
import com.yongoe.ecy.project.entity.Jilu;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 积分记录 convert
 *
 * @author yongoe
 * @since 2024/03/24
 */
@Mapper(componentModel = "spring")
public interface JiluConvert {
    /**
     * entity to vo
     */
    JiluReq entity2Req(Jilu entity);

    JiluRes entity2Res(Jilu entity);

    JiluExcel entity2Excel(Jilu entity);

    /**
     * entity to vo List
     */
    List<JiluReq> entity2ReqList(List<Jilu> list);

    List<JiluRes> entity2ResList(List<Jilu> list);

    List<JiluExcel> entity2ExcelList(List<Jilu> list);

    /**
     * entity to vo Page
     */
    Page<JiluRes> entity2ResPage(Page<Jilu> page);

    /**
     * vo to entity
     */
    Jilu req2Entity(JiluReq req);

    Jilu excel2Entity(JiluExcel excel);

    /**
     * vo to entity List
     */
    List<Jilu> excel2EntityList(List<JiluExcel> list);


}