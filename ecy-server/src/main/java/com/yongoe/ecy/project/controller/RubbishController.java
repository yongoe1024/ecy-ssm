package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.service.JiluService;
import com.yongoe.ecy.project.service.RubbishService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.RubbishExcel;
import com.yongoe.ecy.project.controller.vo.req.RubbishReq;
import com.yongoe.ecy.project.controller.vo.res.RubbishRes;
import com.yongoe.ecy.project.convert.RubbishConvert;
import com.yongoe.ecy.project.entity.Rubbish;
import com.yongoe.ecy.system.service.UserService;
import com.yongoe.ecy.utils.ExcelUtils;
import com.yongoe.ecy.utils.PageUtils;
import com.yongoe.ecy.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.utils.UserUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 垃圾投放
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/rubbish")
public class RubbishController {
    @Resource
    private RubbishService rubbishService;
    @Resource
    private RubbishConvert rubbishConvert;
    @Resource
    private UserService userService;
    @Resource
    private JiluService jiluService;

    /**
     * 通过
     */
    @PostMapping("/yes/{id}")
    public R yes(@PathVariable Long id){
        Rubbish rubbish = rubbishService.getById(id);
        rubbish.setStatus("通过");
        jiluService.updateScore(rubbish.getCreateBy(),1,"垃圾投放");
        rubbishService.updateById(rubbish);
        return R.success("操作成功");
    }

    @PostMapping("/no")
    public R no( Long id,String value){
        Rubbish rubbish = rubbishService.getById(id);
        rubbish.setStatus("拒绝");
        rubbish.setDetials(value);
        rubbishService.updateById(rubbish);
        return R.success("操作成功");
    }

    //@WebLog(description = "垃圾投放-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody RubbishReq req) {
        Rubbish entity = rubbishConvert.req2Entity(req);
        if(UserUtils.isRole("register")) {
            entity.setCreateBy(UserUtils.getName());
        }
        Page<Rubbish> page = rubbishService.getRubbishByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<RubbishRes> resPage = rubbishConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "垃圾投放-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody RubbishReq req) {
        Rubbish rubbish = rubbishConvert.req2Entity(req);
        rubbishService.save(rubbish);
        return R.success("添加成功");
    }

    @WebLog(description = "垃圾投放-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody RubbishReq req) {
        Rubbish rubbish = rubbishConvert.req2Entity(req);
        rubbishService.updateById(rubbish);
        return R.success("修改成功");
    }

    @WebLog(description = "垃圾投放-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        rubbishService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "垃圾投放-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<RubbishExcel> excelList = ExcelUtils.upload(file, RubbishExcel.class);
        List<Rubbish> list = rubbishConvert.excel2EntityList(excelList);
        rubbishService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "垃圾投放-导出数据")
    @GetMapping("/export")
    public void export(RubbishReq req, HttpServletResponse response) {
        Rubbish entity = rubbishConvert.req2Entity(req);
        Page<Rubbish> page = rubbishService.getRubbishByPage(Page.of(-1, -1), entity);
        List<RubbishExcel> list = rubbishConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, RubbishExcel.class);
    }
}