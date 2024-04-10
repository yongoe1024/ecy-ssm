package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.service.GonggaoService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.GonggaoExcel;
import com.yongoe.ecy.project.controller.vo.req.GonggaoReq;
import com.yongoe.ecy.project.controller.vo.res.GonggaoRes;
import com.yongoe.ecy.project.convert.GonggaoConvert;
import com.yongoe.ecy.project.entity.Gonggao;
import com.yongoe.ecy.utils.ExcelUtils;
import com.yongoe.ecy.utils.PageUtils;
import com.yongoe.ecy.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import java.util.List;

/**
 * 公告管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/gonggao")
public class GonggaoController {
    @Resource
    private GonggaoService gonggaoService;
    @Resource
    private GonggaoConvert gonggaoConvert;

    @PostMapping("/public/page")
    public R publicpage(@RequestBody GonggaoReq req) {
        Gonggao entity = gonggaoConvert.req2Entity(req);
        Page<Gonggao> page = gonggaoService.getGonggaoByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<GonggaoRes> resPage = gonggaoConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    //@WebLog(description = "公告管理-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody GonggaoReq req) {
        Gonggao entity = gonggaoConvert.req2Entity(req);
        Page<Gonggao> page = gonggaoService.getGonggaoByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<GonggaoRes> resPage = gonggaoConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "公告管理-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody GonggaoReq req) {
        Gonggao gonggao = gonggaoConvert.req2Entity(req);
        gonggaoService.save(gonggao);
        return R.success("添加成功");
    }

    @WebLog(description = "公告管理-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody GonggaoReq req) {
        Gonggao gonggao = gonggaoConvert.req2Entity(req);
        gonggaoService.updateById(gonggao);
        return R.success("修改成功");
    }

    @WebLog(description = "公告管理-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        gonggaoService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "公告管理-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<GonggaoExcel> excelList = ExcelUtils.upload(file, GonggaoExcel.class);
        List<Gonggao> list = gonggaoConvert.excel2EntityList(excelList);
        gonggaoService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "公告管理-导出数据")
    @GetMapping("/export")
    public void export(GonggaoReq req, HttpServletResponse response) {
        Gonggao entity = gonggaoConvert.req2Entity(req);
        Page<Gonggao> page = gonggaoService.getGonggaoByPage(Page.of(-1, -1), entity);
        List<GonggaoExcel> list = gonggaoConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, GonggaoExcel.class);
    }
}