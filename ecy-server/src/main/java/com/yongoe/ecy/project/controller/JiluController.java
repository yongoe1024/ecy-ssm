package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.service.JiluService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.JiluExcel;
import com.yongoe.ecy.project.controller.vo.req.JiluReq;
import com.yongoe.ecy.project.controller.vo.res.JiluRes;
import com.yongoe.ecy.project.convert.JiluConvert;
import com.yongoe.ecy.project.entity.Jilu;
import com.yongoe.ecy.system.entity.User;
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
 * 积分记录
 *
 * @author yongoe
 * @since 2024/03/24
 */
@RestController
@RequestMapping("/project/jilu")
public class JiluController {
    @Resource
    private JiluService jiluService;
    @Resource
    private JiluConvert jiluConvert;

    @PostMapping("/page")
    public R page(@RequestBody JiluReq req) {
        Jilu jilu = jiluConvert.req2Entity(req);
        jilu.setUserId(UserUtils.getUserId());
        Page<Jilu> page = jiluService.getJiluByPage(Page.of(req.getCurrent(), req.getSize()),jilu );
        Page<JiluRes> resPage = jiluConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "积分记录-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody JiluReq req) {
        Jilu jilu = jiluConvert.req2Entity(req);
        jiluService.save(jilu);
        return R.success("添加成功");
    }

    @WebLog(description = "积分记录-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody JiluReq req) {
        Jilu jilu = jiluConvert.req2Entity(req);
        jiluService.updateById(jilu);
        return R.success("修改成功");
    }

    @WebLog(description = "积分记录-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        jiluService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "积分记录-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<JiluExcel> excelList = ExcelUtils.upload(file, JiluExcel.class);
        List<Jilu> list = jiluConvert.excel2EntityList(excelList);
        jiluService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "积分记录-导出数据")
    @GetMapping("/export")
    public void export(JiluReq req, HttpServletResponse response) {
        Jilu entity = jiluConvert.req2Entity(req);
        Page<Jilu> page = jiluService.getJiluByPage(Page.of(-1, -1), entity);
        List<JiluExcel> list = jiluConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, JiluExcel.class);
    }
}