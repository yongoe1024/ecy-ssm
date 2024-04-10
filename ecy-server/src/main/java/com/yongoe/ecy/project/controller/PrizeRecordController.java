package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.service.PrizeRecordService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.PrizeRecordExcel;
import com.yongoe.ecy.project.controller.vo.req.PrizeRecordReq;
import com.yongoe.ecy.project.controller.vo.res.PrizeRecordRes;
import com.yongoe.ecy.project.convert.PrizeRecordConvert;
import com.yongoe.ecy.project.entity.PrizeRecord;
import com.yongoe.ecy.utils.ExcelUtils;
import com.yongoe.ecy.utils.PageUtils;
import com.yongoe.ecy.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.utils.UserUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import java.util.List;

/**
 * 奖品兑换记录
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/prizerecord")
public class PrizeRecordController {
    @Resource
    private PrizeRecordService prizeRecordService;
    @Resource
    private PrizeRecordConvert prizeRecordConvert;

    //@WebLog(description = "奖品兑换记录-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody PrizeRecordReq req) {
        PrizeRecord entity = prizeRecordConvert.req2Entity(req);
        if(UserUtils.isRole("register")) {
            entity.setCreateBy(UserUtils.getName());
        }
        Page<PrizeRecord> page = prizeRecordService.getPrizeRecordByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<PrizeRecordRes> resPage = prizeRecordConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "奖品兑换记录-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody PrizeRecordReq req) {
        PrizeRecord prizeRecord = prizeRecordConvert.req2Entity(req);
        prizeRecordService.save(prizeRecord);
        return R.success("添加成功");
    }

    @WebLog(description = "奖品兑换记录-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody PrizeRecordReq req) {
        PrizeRecord prizeRecord = prizeRecordConvert.req2Entity(req);
        prizeRecordService.updateById(prizeRecord);
        return R.success("修改成功");
    }

    @WebLog(description = "奖品兑换记录-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        prizeRecordService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "奖品兑换记录-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<PrizeRecordExcel> excelList = ExcelUtils.upload(file, PrizeRecordExcel.class);
        List<PrizeRecord> list = prizeRecordConvert.excel2EntityList(excelList);
        prizeRecordService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "奖品兑换记录-导出数据")
    @GetMapping("/export")
    public void export(PrizeRecordReq req, HttpServletResponse response) {
        PrizeRecord entity = prizeRecordConvert.req2Entity(req);
        Page<PrizeRecord> page = prizeRecordService.getPrizeRecordByPage(Page.of(-1, -1), entity);
        List<PrizeRecordExcel> list = prizeRecordConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, PrizeRecordExcel.class);
    }
}