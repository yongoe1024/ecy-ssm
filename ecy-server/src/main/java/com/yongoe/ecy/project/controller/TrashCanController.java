package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.service.TrashCanService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.TrashCanExcel;
import com.yongoe.ecy.project.controller.vo.req.TrashCanReq;
import com.yongoe.ecy.project.controller.vo.res.TrashCanRes;
import com.yongoe.ecy.project.convert.TrashCanConvert;
import com.yongoe.ecy.project.entity.TrashCan;
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
 * 垃圾桶管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/trashcan")
public class TrashCanController {
    @Resource
    private TrashCanService trashCanService;
    @Resource
    private TrashCanConvert trashCanConvert;

    @PostMapping("/public/page")
    public R publicpage(@RequestBody TrashCanReq req) {
        TrashCan entity = trashCanConvert.req2Entity(req);
        Page<TrashCan> page = trashCanService.getTrashCanByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<TrashCanRes> resPage = trashCanConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    //@WebLog(description = "垃圾桶管理-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody TrashCanReq req) {
        TrashCan entity = trashCanConvert.req2Entity(req);
        Page<TrashCan> page = trashCanService.getTrashCanByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<TrashCanRes> resPage = trashCanConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "垃圾桶管理-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody TrashCanReq req) {
        TrashCan trashCan = trashCanConvert.req2Entity(req);
        trashCanService.save(trashCan);
        return R.success("添加成功");
    }

    @WebLog(description = "垃圾桶管理-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody TrashCanReq req) {
        TrashCan trashCan = trashCanConvert.req2Entity(req);
        trashCanService.updateById(trashCan);
        return R.success("修改成功");
    }

    @WebLog(description = "垃圾桶管理-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        trashCanService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "垃圾桶管理-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<TrashCanExcel> excelList = ExcelUtils.upload(file, TrashCanExcel.class);
        List<TrashCan> list = trashCanConvert.excel2EntityList(excelList);
        trashCanService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "垃圾桶管理-导出数据")
    @GetMapping("/export")
    public void export(TrashCanReq req, HttpServletResponse response) {
        TrashCan entity = trashCanConvert.req2Entity(req);
        Page<TrashCan> page = trashCanService.getTrashCanByPage(Page.of(-1, -1), entity);
        List<TrashCanExcel> list = trashCanConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, TrashCanExcel.class);
    }
}