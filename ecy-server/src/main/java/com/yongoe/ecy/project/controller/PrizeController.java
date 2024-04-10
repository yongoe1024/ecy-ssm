package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.entity.PrizeRecord;
import com.yongoe.ecy.project.service.JiluService;
import com.yongoe.ecy.project.service.PrizeRecordService;
import com.yongoe.ecy.project.service.PrizeService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.PrizeExcel;
import com.yongoe.ecy.project.controller.vo.req.PrizeReq;
import com.yongoe.ecy.project.controller.vo.res.PrizeRes;
import com.yongoe.ecy.project.convert.PrizeConvert;
import com.yongoe.ecy.project.entity.Prize;
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
import java.util.List;

/**
 * 奖品管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/prize")
public class PrizeController {
    @Resource
    private PrizeService prizeService;
    @Resource
    private PrizeConvert prizeConvert;
    @Resource
    private UserService userService;
    @Resource
    private PrizeRecordService prizeRecordService;
    @Resource
    private JiluService jiluService;

    @PostMapping("/public/page")
    public R publicpage(@RequestBody PrizeReq req) {
        Prize entity = prizeConvert.req2Entity(req);
        Page<Prize> page = prizeService.getPrizeByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<PrizeRes> resPage = prizeConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @PostMapping("/buy/{id}")
    public R page(@PathVariable Long id) {
        Prize prize = prizeService.getById(id);
        String score = prize.getScore();
        Integer num = prize.getNum();
        if (num <= 0) {
            return R.error("库存不足");
        }
        Integer score1 = userService.getUserById(UserUtils.getUserId()).getScore();
        if (Integer.parseInt(score) >score1) {
            return R.error("积分不足");
        }
        String prizeName = prize.getName();
        prize.setNum(prize.getNum() - 1);
        prizeService.updateById(prize);
        jiluService.updateScore(UserUtils.getName(), -Integer.parseInt(prize.getScore()), "兑换" + prizeName );
        PrizeRecord prizeRecord = new PrizeRecord();
        prizeRecord.setPrizeName(prizeName);
        prizeRecordService.save(prizeRecord);
        return R.success("成功");
    }

    //@WebLog(description = "奖品管理-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody PrizeReq req) {
        Prize entity = prizeConvert.req2Entity(req);
        Page<Prize> page = prizeService.getPrizeByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<PrizeRes> resPage = prizeConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "奖品管理-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody PrizeReq req) {
        Prize prize = prizeConvert.req2Entity(req);
        prizeService.save(prize);
        return R.success("添加成功");
    }

    @WebLog(description = "奖品管理-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody PrizeReq req) {
        Prize prize = prizeConvert.req2Entity(req);
        prizeService.updateById(prize);
        return R.success("修改成功");
    }

    @WebLog(description = "奖品管理-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        prizeService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "奖品管理-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<PrizeExcel> excelList = ExcelUtils.upload(file, PrizeExcel.class);
        List<Prize> list = prizeConvert.excel2EntityList(excelList);
        prizeService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "奖品管理-导出数据")
    @GetMapping("/export")
    public void export(PrizeReq req, HttpServletResponse response) {
        Prize entity = prizeConvert.req2Entity(req);
        Page<Prize> page = prizeService.getPrizeByPage(Page.of(-1, -1), entity);
        List<PrizeExcel> list = prizeConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, PrizeExcel.class);
    }
}